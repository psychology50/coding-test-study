import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\input.txt"));
        PrintWriter pw = new PrintWriter("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\output.txt");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            boolean mark = false;
            int j = i;
            while (j > 0) { // 1
                if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9) { // 322 2 2 3
                    sb.append("-");
                    mark = true;
                }
                j /= 10;
            }
            if (mark) sb.append(" ");
            else sb.append(i).append(" "); // 1
        }
        //        pw.println(sb);
        //        pw.close();
        System.out.println(sb);
    }
}
