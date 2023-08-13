import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<Integer> number = new ArrayList<>();
    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()){
            number.add(Integer.valueOf(st.nextToken()));
        }
    }

    public static void main(String[] args) throws IOException{
        getData();
        int x, y;
        x = (int) ((number.get(0) - (Math.sqrt(Math.pow(number.get(0), 2) - 4 * number.get(1)))) / 2);
        y = (int) ((number.get(0) + (Math.sqrt(Math.pow(number.get(0), 2) - 4 * number.get(1)))) / 2);
        String result = x + " " + y;
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}