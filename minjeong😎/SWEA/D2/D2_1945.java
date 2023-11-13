import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class D2_1945 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\input.txt"));
        PrintWriter pw = new PrintWriter("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\output.txt");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());

            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;

            while (num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0 || num % 11 == 0){
                if (num % 2 == 0) {
                    a++;
                    num /= 2;
                }
                if (num % 3 == 0) {
                    b++;
                    num /= 3;
                }
                if (num % 5 == 0) {
                    c++;
                    num /= 5;
                }
                if (num % 7 == 0) {
                    d++;
                    num /= 7;
                }
                if (num % 11 == 0) {
                    e++;
                    num /= 11;
                }
            }

            sb.append("#").append(i+1).append(" ")
                    .append(a).append(" ")
                    .append(b).append(" ")
                    .append(c).append(" ")
                    .append(d).append(" ")
                    .append(e).append("\n");
        }
        pw.println(sb);
        pw.close();
    }
}
