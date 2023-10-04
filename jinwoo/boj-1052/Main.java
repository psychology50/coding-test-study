import java.util.*;
import java.io.*;

class Main {
    private static int n;
    private static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int answer = 0;

        while (Integer.bitCount(n) > k) {
            answer += n & (-n);
            n += n & (-n);
        }

        System.out.println(answer);
    }
}