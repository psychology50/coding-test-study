import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class D2_1966 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\input.txt"));
        PrintWriter pw = new PrintWriter("C:\\Users\\sec\\IdeaProjects\\coding-test-study\\src\\output.txt");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            list.sort(Comparator.naturalOrder()); // 구글링

            sb.append("#").append(i + 1).append(" ");

            for (int j = 0; j < N; j++) {
                sb.append(list.get(j)).append(" ");
            }

            sb.append("\n");
        }
        //        pw.println(sb);
        //        pw.close();
        System.out.println(sb);
    }
}
