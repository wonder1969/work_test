import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        String symbol;
        ArrayList<Integer> number = new ArrayList<>();
        String str;
        FileReader file = new FileReader("D:\\JavaProjects\\work_test\\task_6\\src\\input.txt");
        Scanner sc = new Scanner(file);
        str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            number.add(Integer.valueOf(st.nextToken()));
        }
        symbol = (number.get(0) * number.get(1) >= number.get(2)) ? "YES" : "NO";
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(symbol);
        fileOut.close();
    }
}