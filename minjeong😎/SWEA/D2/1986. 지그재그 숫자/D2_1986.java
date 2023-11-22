import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class D2_1986 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\input.txt"));
        PrintWriter pw = new PrintWriter("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\output.txt");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int sum = 1;
            for (int j = 2; j <=num; j++) {
                if (j % 2 == 0) sum -= j;
                else sum += j;
            }
            sb.append("#").append(i+1).append(" ")
                    .append(sum).append("\n");
        }

        pw.println(sb);
        pw.close();
    }
}
