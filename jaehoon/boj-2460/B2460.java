package baekjoon;

import java.util.Scanner;

public class B2460 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] down = new int[10];
		int[] up = new int[10];
		for (int i = 0; i < 10; i++) {
			down[i] = sc.nextInt();
			up[i] = sc.nextInt();
		}

		int[] total = new int[10];
		total[0] = up[0];
		for (int i = 1; i < 10; i++) {
			total[i] = total[i - 1] - down[i] + up[i];
//			if (total[i] > 10000) {
//				total[i] = 10000;
//			}
		}

		int max = -1;
		for (int i = 0; i < 10; i++) {
			if (total[i] > max)
				max = total[i];
		}
		System.out.println(max);

		sc.close();

	}

}
