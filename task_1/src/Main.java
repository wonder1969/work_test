import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String str;
        FileReader fin = new FileReader("D:\\JavaProjects\\work_test\\task_1\\src\\input.txt");
        Scanner sc = new Scanner(fin);
        str = sc.nextLine();
        FileWriter StepFinish = new FileWriter("output.txt");
        StepFinish.write(str);
        StepFinish.close();
    }
}