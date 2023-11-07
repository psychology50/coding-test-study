import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static final int MAX_VALUE = 250;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[MAX_VALUE + 1];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        for (int i = 3; i <= MAX_VALUE; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigInteger("2")));
        }

        while (true) {
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());
                BigInteger n = new BigInteger(st.nextToken());

                System.out.println(dp[n.intValue()]);
            } catch (Exception e) {
                break;
            }
        }
    }
}
