package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S17086 {

	public static int n;
	public static int m;

	public static int[][] map;
	public static int[][] visited;
	public static int safeDistance = -1;

	public static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	public static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited = new int[n][m];

		visited[x][y] = 1;
		q.offer(new int[] { x, y, 0 });

		while (!q.isEmpty()) {
			int[] pop = q.poll();

			for (int i = 0; i < 8; i++) {
				int newX = pop[0] + dx[i];
				int newY = pop[1] + dy[i];
				int distance = pop[2] + 1;

				if (newX < 0 || newY < 0 || newX >= n || newY >= m || visited[newX][newY] == 1) {
					continue;
				}

				if (map[newX][newY] == 1) {
					safeDistance = distance;
					return;
				}

				q.offer(new int[] { newX, newY, distance });
				visited[newX][newY] = 1;

			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1)
					continue;
				bfs(i, j);
				if (max < safeDistance)
					max = safeDistance;
			}
		}

		System.out.println(max);

		sc.close();

	}

}
