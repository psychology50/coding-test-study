package baekjoon;

import java.util.Scanner;

public class S16173 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int mapSize = sc.nextInt();

		int[][] map = new int[mapSize][mapSize];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		if (mapSize == 2) {
			if (map[0][0] == 1 && map[0][1] == 1 || map[0][0] == 1 && map[1][0] == 1)
				System.out.println("HaruHaru");
			else {
				System.out.println("Hing");
			}
		}
		if (mapSize == 3) {
			if (map[0][0] == 1) {
				if ((map[0][1] == 1 && map[1][1] == 1 && map[1][2] == 1)
						|| (map[1][0] == 1 && map[1][1] == 1 && map[2][1] == 1)) {
					System.out.println("HaruHaru");
					System.exit(0);
				}
				if ((map[0][1] == 2 && map[2][1] == 1) || (map[1][0] == 2 && map[1][2] == 1)
						|| (map[0][1] == 1 && map[1][1] == 1 && map[2][1] == 1)
						|| (map[1][0] == 1 && map[1][1] == 1 && map[1][2] == 1)) {
					System.out.println("HaruHaru");
					System.exit(0);
				}
				if (map[0][2] == 2 || map[2][0] == 2
						|| ((map[0][2] == 1 && map[1][2] == 1) || (map[2][0] == 1 && map[2][1] == 1))) {
					System.out.println("HaruHaru");
					System.exit(0);
				}
			}

			else if (map[0][0] == 2) {
				if (map[0][2] == 2 || map[2][0] == 2
						|| ((map[0][2] == 1 && map[1][2] == 1) || (map[2][0] == 1 && map[2][1] == 1))) {
					System.out.println("HaruHaru");
					System.exit(0);
				}
			}

			System.out.println("Hing");
		}

		sc.close();

	}

}
