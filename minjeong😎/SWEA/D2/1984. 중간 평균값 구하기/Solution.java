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

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> numList = new ArrayList<Integer>();
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                numList.add(num);
            }

            numList.sort(Comparator.naturalOrder());

            int sum = 0;

            for (int j = 1; j < numList.size()-1; j++) {
                sum += numList.get(j);
            }
            double avg = sum/8.0;

            sb.append("#").append(i+1).append(" ").append(Math.round(avg)).append("\n");
        }
        //        pw.println(sb);
        //        pw.close();
        System.out.println(sb);
    }
}
