import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<Integer> berryCount = new ArrayList<>();
    private static ArrayList<Integer> berrySum = new ArrayList<>();
    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()) {
                berryCount.add(Integer.valueOf(st.nextToken()));
            }
        }
    }
    public static void main(String[] argv) throws IOException{
        getData();
        for (int i = 0; i < berryCount.size(); i++) {
            if (i == 0) {
                berryCount.remove(0);
            }
        }

        berryCount.add(berryCount.get(0));
        berryCount.add(berryCount.get(1));

        int result = 0;
        for (int i = 0; i < berryCount.size(); i++) {
            if (i + 1 < berryCount.size() && i + 2 < berryCount.size()) {
                result = berryCount.get(i) + berryCount.get(i + 1) + berryCount.get(i + 2);
            }
            berrySum.add(result);
            result = 0;
        }

        berrySum.sort(Collections.reverseOrder());
        result = berrySum.get(0);
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(result));
        pw.close();
    }
}