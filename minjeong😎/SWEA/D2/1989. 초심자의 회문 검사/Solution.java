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
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken(); // level
            String reverse = "";
            int result;
            for (int j = word.length()-1; j >= 0; j--) { // j = 4 3 2 1 0
                reverse += word.charAt(j);
            }
            if (reverse.equals(word)) { // String은 ==가 아닌 .equals()로 비교함!!
                result = 1;
            }
            else {
                result = 0;
            }
            sb.append("#").append(i+1).append(" ").append(result).append("\n");
        }
        //        pw.println(sb);
        //        pw.close();
        System.out.println(sb);
    }
}
