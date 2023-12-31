import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String symbol;
        ArrayList<Integer> number = new ArrayList<>();
        String str;
        FileReader file = new FileReader("D:\\JavaProjects\\work_test\\task_5\\src\\input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            str = sc.nextLine();
            number.add(Integer.valueOf(str));
        }
        symbol = (number.get(0) > number.get(1)) ? ">" : // Проверка условия задачи
                (number.get(0) < number.get(1)) ? "<" : "=";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(symbol);
        fileOut.close();
    }
}