package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11170 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

			int cnt = 0;
			for (int j = n; j <= m; j++) {
				int current = j;
				if (current == 0)
					cnt++;

				while (current >= 1) {
					if (current % 10 == 0) {
						cnt++;
					}
					current /= 10;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}

}
