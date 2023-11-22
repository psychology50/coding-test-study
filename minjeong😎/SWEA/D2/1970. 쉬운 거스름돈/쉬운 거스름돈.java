import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			int[] coins = new int[8];

			// 고려해야 할 것: 5000원 1000원 500원 100원 50원 10원
			int cnt = 0;
			while (money > 0) { // 1999990 1000 
				cnt++;
				if (cnt == 2) { // 10원 50원
					if (money % 10 >= 5)
						coins[6]++;
					coins[7] += (money % 10) % 5;
				} else if (cnt == 3) {
					if (money % 10 >= 5)
						coins[4]++;
					coins[5] += (money % 10) % 5;
				} else if (cnt == 4) {
					if (money % 10 >= 5)
						coins[2]++;
					coins[3] += (money % 10) % 5;
				} else if (cnt == 5) {
					if (money % 10 >= 5)
						coins[0]++;
					coins[1] += (money % 10) % 5;
				} else if (cnt >= 6) {
					coins[0] += money * 10 / 5;
					break;
				}

				money /= 10;
			}
			sb.append("#").append(i).append("\n");
			for (int j = 0; j < 8; j++) {
				sb.append(coins[j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
