import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1_2043 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken()); // 4
        int k = Integer.parseInt(st.nextToken()); // 1
        int cnt = 0;

        while (k < 999) {
            if (k == p) {
                cnt++; // 4
                break;
            }
            cnt++; // 1 2 3
            k++; // 2 3 4
        }

        System.out.printf(String.format("%d", cnt));
    }
}
