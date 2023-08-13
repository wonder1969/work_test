import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<String> data = new ArrayList<>();
    private static ArrayList<String> imgOriginal = new ArrayList<>();
    private static ArrayList<String> imgNegative = new ArrayList<>();

    private static void getData() throws IOException{
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()){
                data.add(st.nextToken());
            }
        }
    }

    private static void dataProcessing() {
        for (int i = 0; i < data.size(); i++){
            int numberLine = Integer.valueOf(data.get(0));
            if (i != 0 && i != 1){
                if (i < numberLine + 2){
                    char[] chOrigig = data.get(i).toCharArray();
                    for (char aChOrigig : chOrigig) {
                        imgOriginal.add(String.valueOf(aChOrigig));
                    }
                } else {
                    char[] chNegative = data.get(i).toCharArray();
                    for (char aChNegative : chNegative) {
                        String symbol = String.valueOf(aChNegative);
                        if (symbol.equals("B")) {
                            imgNegative.add("W");
                        } else {
                            imgNegative.add("B");
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        getData();
        dataProcessing();
        int wrong = 0;
        for (int i = 0; i < imgNegative.size(); i++){
            if(!imgOriginal.get(i).equals(imgNegative.get(i))){
                wrong++;
            }
        }
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(wrong));
        pw.close();
    }
}