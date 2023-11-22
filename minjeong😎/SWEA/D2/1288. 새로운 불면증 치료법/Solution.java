import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\input.txt"));
        PrintWriter pw = new PrintWriter("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\output.txt");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            ArrayList<Integer> mark = new ArrayList<Integer>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int k = 1;
            // N = 1
            while (true) {
                int num = N * k; // 1 2 3 4 5 6 7 8 9 10
                while (num > 0) {
                    if (!mark.contains(num % 10)) mark.add(num % 10); // 1 2 ...9 // 0 1
                    num /= 10; // 1
                }
                if (mark.size() >= 10) break;
                k++; // 2 3...10
            }

            sb.append("#").append(i+1).append(" ").append(k*N).append("\n");
        }
        //        pw.println(sb);
        //        pw.close();
        System.out.println(sb);
    }
}
