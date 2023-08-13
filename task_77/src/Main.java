import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer> team = new ArrayList<>();
    private static ArrayList<Integer> startData = new ArrayList<>();

    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int numberLine = 0;
        while (sc.hasNextLine()){
            numberLine++;
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                if (numberLine == 2){
                    team.add(Integer.valueOf(st.nextToken()));
                } else {
                    startData.add(Integer.valueOf(st.nextToken()));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        getData();
        int roomCount = startData.get(1);
        int contestant = 0;
        for (Integer aTeam : team){
            if (roomCount >= aTeam) {
                contestant += aTeam;
            } else {
                contestant += roomCount;
            }
        }
        PrintWriter pw = new PrintWriter("outout.txt");
        pw.print(String.valueOf(contestant));
        pw.close();
    }
}