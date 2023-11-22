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
            ArrayList<Integer> maxList = new ArrayList<Integer>();
            ArrayList<Integer> minList = new ArrayList<Integer>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                if (N > M)
                    maxList.add(Integer.parseInt(st.nextToken()));
                else if (N < M)
                    minList.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                if (N < M)
                    maxList.add(Integer.parseInt(st.nextToken()));
                else if (N > M)
                    minList.add(Integer.parseInt(st.nextToken()));
            }

            int maxSum = 0;
            int j = 0;

            while (true) {
                int newSum = 0;
                int r = j; // 0 1
                // minList 사이즈: 3
                for (int t = 0; t < minList.size(); t++) {
                    newSum += minList.get(t) * maxList.get(j); //j=0 1*3 , j=1 2*6 j=2 3*-3 => 4 // 1*6 5*-7 3*5 => -14 / 1*-7+5*5+3*4=>30
                    j++; //
                }
                r++; // 1 2 3 3
                j = r; // 1 2

                if (newSum > maxSum) maxSum = newSum; // 4
                if (j + minList.size() - 1 >= maxList.size()) break;
            }

            sb.append("#").append(i + 1).append(" ").append(maxSum);
            sb.append("\n");
        }
        //        pw.println(sb);
        //        pw.close();
        System.out.println(sb);
    }
}
