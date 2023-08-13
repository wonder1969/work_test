import java.util.*;
import java.io.*;

public class Main {
    private static final ArrayList<String> col_list = new ArrayList<>(); // Коллекция для построчного считывания данных
    private static final ArrayList<Integer> time = new ArrayList<>(); // Коллекция для хранения времени на решение задач
    private static int taskCountOne = 0, taskCountThree = 0, taskCountFive = 0; // Количество решенных задач
    private static int mistakeCountOne = 0, mistakeCountThree = 0, mistakeCountFive = 0; // Количество штрафного времени по каждому заданию
    private static int mistakeAllOne = 0, mistakeAllThree = 0, mistakeAllFive = 0; // Количество штрафного времени по каждому заданию
    private static int maxTime = 300; // Максимальная продолжительность соревнований

    private static void FirstCourse(){
        Collections.sort(time);
        int one = 0;
        for (Integer aTime : time) { // Расчет по первокурснику
            if (one >= 0) {
                one = maxTime - aTime;
                maxTime = one;
                taskCountOne++;
                mistakeCountOne += aTime;
                mistakeAllOne += mistakeCountOne;
            } else {
                break;
            }
        }
    }

    private static void ThirdCourse(){
        Collections.reverse(time);
        int three = 0;
        for (Integer aTime : time) { // Расчет по третьекурснику
            if (three >= 0) {
                three = maxTime - aTime;
                maxTime = three;
                taskCountThree++;
                mistakeCountThree += aTime;
                mistakeAllThree += mistakeCountThree;
            } else {
                break;
            }
        }
    }

    private static void FifthCourse(){
        int five = 0;
        for (Integer aTime : time) { // Расчет по пятикурснику
            if (five >= 0) {
                five = maxTime - aTime;
                maxTime = five;
                taskCountFive++;
                mistakeCountFive += aTime;
                mistakeAllFive += mistakeCountFive;
            } else {
                break;
            }
        }
    }

    private static void time(){
        maxTime = 300;
    }

    public static void main(String[] args) throws IOException {

        String str;
        FileReader file = new FileReader("D:\\JavaProjects\\work_test\\task_4\\src\\input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            str = sc.nextLine();
            col_list.add(str);
        }
        StringTokenizer st = new StringTokenizer(col_list.get(1), " ");
        while(st.hasMoreTokens()){
            time.add(Integer.valueOf(st.nextToken()));
        }
        FifthCourse();
        time();
        ThirdCourse();
        time();
        FirstCourse();

        // Определение победителя
        String winner = (taskCountOne > taskCountThree && taskCountOne > taskCountFive) ? "1" :
                (taskCountThree > taskCountOne && taskCountThree > taskCountFive) ? "3" : "5";

        if(taskCountOne == taskCountThree && taskCountOne > taskCountFive){
            winner = (mistakeAllOne == mistakeAllThree) ? "1" :
                    (mistakeAllOne > mistakeAllThree) ? "3" : "1";
        }else if(taskCountOne == taskCountFive && taskCountOne > taskCountThree){
            winner = (mistakeAllOne == mistakeAllFive) ? "1" :
                    (mistakeAllOne > mistakeAllFive) ? "5" : "1";
        }else if(taskCountThree == taskCountFive && taskCountThree > taskCountOne){
            winner = (mistakeAllThree == mistakeAllFive) ? "3" :
                    (mistakeAllThree > mistakeAllFive) ? "5" : "3";
        }else{
            if(taskCountOne == taskCountThree && taskCountOne == taskCountFive) {
                winner = (mistakeAllOne == mistakeAllThree && mistakeAllOne == mistakeAllFive) ? "1" :
                        (mistakeAllOne == mistakeAllThree && mistakeAllOne < mistakeAllFive) ? "1" :
                                (mistakeAllThree == mistakeCountFive && mistakeAllThree < mistakeAllOne) ? "3" :
                                        (mistakeAllOne == mistakeAllFive && mistakeAllOne < mistakeAllThree) ? "1" :
                                                (mistakeAllFive < mistakeAllThree && mistakeAllFive < mistakeAllOne) ? "5" :
                                                        (mistakeAllThree < mistakeAllFive && mistakeAllThree < mistakeAllOne) ? "3" : "1";
            }
        }
        FileWriter countStepFinish = new FileWriter("output.txt");// Запись числа в файл
        countStepFinish.write(winner);
        countStepFinish.close();
    }
}