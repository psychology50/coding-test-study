import java.util.*;
import java.io.*;

public class Main {
    static int result = 0;
    static int n;
    static int[][] dp;
    static int[] a, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[n][n];

        a = new int[n];
        b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        System.err.println(recursion(0, 0));
        br.close();
    }

    public static int recursion(int left, int right) {
        // 기저사례: 왼쪽 카드 고갈 혹은 오른쪽 카드 고갈
        if (left == n || right == n) {
            return 0;
        }

        // DP - 이미 방문한 값은 캐싱
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        dp[left][right] = 0;

        int result1 = recursion(left + 1, right);
        int result2 = recursion(left + 1, right + 1);

        int result3 = 0;
        if (a[left] > b[right]) {
            result3 = b[right] + recursion(left, right + 1);
        }

        return dp[left][right] = Math.max(Math.max(result1, result2), result3);
    }
}
