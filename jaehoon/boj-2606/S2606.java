package baekjoon;

import java.util.Scanner;

public class S2606 {
	
	public static int cnt = 0;

	public static void dfs(int start, int[][] map, int[] visited) {
		if (visited[start] == 1) {
			return;
		}
		visited[start] = 1;
		cnt++;

		for (int i = 1; i < map.length; i++) {
			if (map[start][i] == 1 && visited[i] == 0) {
				dfs(i, map, visited);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int vertex, edge;
		vertex = sc.nextInt();
		edge = sc.nextInt();

		int[][] map = new int[vertex + 1][vertex + 1];
		int[] visited = new int[vertex + 1];

		for (int i = 0; i < edge; i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			map[left][right] = map[right][left] = 1;
		}

		
		dfs(1, map, visited);
		
		System.out.println(--cnt);
		
		sc.close();

	}

}
