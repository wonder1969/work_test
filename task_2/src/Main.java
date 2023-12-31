import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> numeric = new ArrayList<>();
        int s = 0;
        String str;
        FileReader fin = new FileReader("D:\\JavaProjects\\work_test\\task_2\\src\\input.txt"); // Получение чисел из файла
        Scanner sc = new Scanner(fin);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            int a = Integer.valueOf(st.nextToken());
            numeric.add(a);
        }
        for (Integer aNumeric : numeric) {
            s += aNumeric;
        }
        FileWriter countStepFinish = new FileWriter("output.txt");// Запись числа в файл
        countStepFinish.write(String.valueOf(s));
        countStepFinish.close();
    }
}