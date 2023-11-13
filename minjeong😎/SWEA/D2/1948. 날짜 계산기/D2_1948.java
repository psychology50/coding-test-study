import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D2_1948 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\input.txt"));
        PrintWriter pw = new PrintWriter("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\output.txt");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int m1 = 1;
        int m2 = 1;
        int d1 = 1;
        int d2 = 1;
        int days;

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days = 0;

            m1 = Integer.parseInt(st.nextToken());
            d1 = Integer.parseInt(st.nextToken());
            m2 = Integer.parseInt(st.nextToken());
            d2 = Integer.parseInt(st.nextToken());

            while (m1 < m2 || m1 == m2) {
                if (days == 0 && m1 == m2) {
                    days = d2 - d1 + 1;
                    break;
                }
                else if (m1 == 1 || m1 == 3 || m1 == 5 || m1 == 7 || m1 == 8 || m1 == 10 || m1 == 12) {
                    if (days == 0) days = days + 31 - d1 + 1;
                    else if (m1 == m2) days += d2;
                    else days += 31;
                }
                else if (m1 == 4 || m1 == 6 || m1 == 9 || m1 == 11) {
                    if (days == 0) days = days + 30 - d1 + 1;
                    else if (m1 == m2) days += d2;
                    else days += 30;
                } else {
                    if (days == 0) days = days + 28 - d1 + 1;
                    else if (m1 == m2) days += d2;
                    else days += 28;
                }
                m1++;
            }
            sb.append("#").append(i + 1).append(" ").append(days).append("\n");
    }

//        pw.println(sb);
//        pw.close();
        System.out.println(sb);
    }
}
