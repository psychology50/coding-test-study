import java.util.*;
import java.io.*;

class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int target = 0;
        int len = 1;
        int cnt = 9;

        while (K > cnt * len) {
            K -= (len * cnt);
            target += cnt;

            len++;
            cnt *= 10;
        }

        target = (target + 1) + (K -  1) / len;
        
        if (target > N) {
			System.out.println(-1);
		} else {
			int idx = (int)((K-1)%len);
			System.out.println(String.valueOf(target).charAt(idx));
		}

        br.close();
    }
}