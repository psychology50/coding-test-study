import java.util.*;
import java.io.*;

class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long target = 0;
        long len = 1;
        long cnt = 9;

        while (K > (len * cnt)) {
            K -= (len * cnt);
            target += cnt;
            len++;
            cnt *= 10;
        }

        target += ((K - 1) / len) + 1;
        
        if (target > N) {
			System.out.println(-1);
		} else {
			int idx = (int) ((K-1) % len);
			System.out.println(String.valueOf(target).charAt(idx));
		}

        br.close();
    }
}