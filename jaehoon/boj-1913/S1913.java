package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1913 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int findNum = Integer.parseInt(br.readLine());

		int[][] box = new int[n][n];

		// 위 오른쪽 아래 왼쪽
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int currentX = n / 2;
		int currentY = n / 2;

		int cnt = 1;
		int checkRound = 2;
		int direction = 2;
		while (true) {
			if (cnt >= n * n)
				break;

			if (cnt == 1) {
				box[currentX][currentY] = cnt;
				currentX += dx[0];
				currentY += dy[0];
				cnt++;
				continue;
			}
			if (cnt == 2) {
				box[currentX][currentY] = cnt;
				currentX += dx[1];
				currentY += dy[1];
				cnt++;
				continue;
			}

			direction %= 4;

			switch (direction) {
			case 0:
				for (int i = 0; i < checkRound; i++) {
					box[currentX][currentY] = cnt;
					currentX += dx[0];
					currentY += dy[0];
					cnt++;
				}
				break;
			case 1:
				for (int i = 0; i < checkRound; i++) {
					box[currentX][currentY] = cnt;
					currentX += dx[1];
					currentY += dy[1];
					cnt++;
				}
				break;
			case 2:
				for (int i = 0; i < checkRound; i++) {
					box[currentX][currentY] = cnt;
					currentX += dx[2];
					currentY += dy[2];
					cnt++;
				}
				break;
			case 3:
				for (int i = 0; i < checkRound; i++) {
					box[currentX][currentY] = cnt;
					currentX += dx[3];
					currentY += dy[3];
					cnt++;
				}
				break;
			}

			if (cnt % 2 == 1) {
				direction++;
				checkRound++;
			}
			for (int i = 1; i < n; i++)
				if ((cnt - (checkRound - 1)) == 3 + 2 * (i + 1) || (cnt - (checkRound - 1)) == 3)
					checkRound--;

		}
		box[0][0] = n * n;

		
		StringBuilder stringBuilder = new StringBuilder();
		
		int resX = -1;
		int resY = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (findNum == box[i][j]) {
					resX = i;
					resY = j;
				}
				stringBuilder.append(box[i][j] + " ");
			}
			stringBuilder.append("\n");
		}
		stringBuilder.append(resX + " " + resY);
		System.out.println(stringBuilder.toString());
		

	}

}
