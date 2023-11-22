import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
	// 달팽이 어려워.. 
	// 블로그 참고: https://velog.io/@dudrkdl777/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98SWEA-1954.-%EB%8B%AC%ED%8C%BD%EC%9D%B4-%EC%88%AB%EC%9E%90D2-Java

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// PrintWriter pw = new PrintWriter("C:\\Users\\samsung\\Downloads\\result.txt");
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ").append("\n");
			int N = Integer.parseInt(br.readLine());
			
			int[][] box = new int[N][N];
			boolean[][] mark = new boolean[N][N];
			//        -1,0
			// 0,-1 <- 0,0 -> 0,1
			//         1,0 
			int[] dx = new int[]{0, 1, 0, -1}; // 우, 하, 좌, 상
			int[] dy = new int[]{1, 0, -1, 0};
			
			int dir = 0;
			int x = 0; // box의 좌표
			int y = 0;
			for (int j = 1; j <= N*N; j++) {
				box[x][y] = j;
				mark[x][y] = true;
				
				int nextx = x + dx[dir];
				int nexty = y + dy[dir];
				
				if (nextx >= N || nexty >= N || nextx < 0 || nexty < 0 || mark[nextx][nexty]) {
					dir = (dir + 1) % 4;
				}
				
				x += dx[dir];
				y += dy[dir];
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					sb.append(box[j][k]).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
		// pw.println(sb);
		// pw.close();
	}
}
