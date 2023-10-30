package baekjoon;

import java.util.Scanner;

public class S16173 {

	public static void dfs(int x, int y, int[][] map, boolean[][] visited) {
		if (visited[x][y]) {
			return;
		}
		visited[x][y] = true;

		if (map[x][y] == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}

		if (y + map[x][y] < map.length) {
			dfs(x, y + map[x][y], map, visited);
		}
		if (x + map[x][y] < map.length) {
			dfs(x + map[x][y], y, map, visited);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int mapSize = sc.nextInt();

		int[][] map = new int[mapSize][mapSize];
		boolean[][] visited = new boolean[mapSize][mapSize];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
				visited[i][j] = false;
			}
		}

		dfs(0, 0, map, visited);

		System.out.println("Hing");

		sc.close();

	}

}
