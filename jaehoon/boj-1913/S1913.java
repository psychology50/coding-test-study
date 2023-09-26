package baekjoon;

import java.util.Scanner;

public class S1913 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int findNum = sc.nextInt();

		int[][] box = new int[n][n];
		// 위 오른쪽 아래 왼쪽
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int currentX = n / 2;
		int currentY = n / 2;

		int cnt = 1;
		int checkRound = 1;
		int direction = 0;
		boolean isStay = true;
		for (; cnt <= n * n;) {

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
			direction++;

			if (isStay) {
				isStay = false;
				continue;
			}

			checkRound++;
			isStay = true;

		}

		StringBuilder stringBuilder = new StringBuilder();

		int resX = -1;
		int resY = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (findNum == box[i][j]) {
					resX = i + 1;
					resY = j + 1;
				}
				stringBuilder.append(box[i][j] + " ");
			}
			stringBuilder.append("\n");
		}
		stringBuilder.append(resX + " " + resY);
		System.out.println(stringBuilder.toString());

		sc.close();

	}

}
