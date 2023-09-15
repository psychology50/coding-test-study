package baekjoon;

import java.util.Scanner;

public class B14467 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		int[] cow = new int[10];
		for (int i = 0; i < cow.length; i++) {
			cow[i] = -1;
		}

		int cnt = 0;
		int cowIndex, cowLocation;
		for (int i = 0; i < input; i++) {
			cowIndex = sc.nextInt();
			cowLocation = sc.nextInt();

			if ((cow[cowIndex - 1] != cowLocation) && (cow[cowIndex - 1] != -1))
				cnt++;

			cow[cowIndex - 1] = cowLocation;

		}
		System.out.println(cnt);

		sc.close();

	}

}
