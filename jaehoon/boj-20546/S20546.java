package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S20546 {

	public static int check(int[] chart, int day) {
		int[] check = new int[3];
		Arrays.fill(check, -1);

		int cnt = 0;
		for (int i = day - 3; i < day; i++) {
			if (chart[i] < chart[i + 1]) {
				check[cnt] = 1;
				cnt++;
			} else if (chart[i] > chart[i + 1]) {
				check[cnt] = 0;
				cnt++;
			} else {
				cnt++;
			}
		}

		int flag = 0;
		for (int i = 0; i < check.length; i++) {
			if (check[i] == 1) {
				flag++;
			} else if (check[i] == 0) {
				flag--;
			} else
				return -1;
		}

		if (flag == 3) // 전량 매도
			return 1;
		else if (flag == -3) // 전량 매수
			return 0;

		return -1;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] chart = new int[14];
		for (int i = 0; i < chart.length; i++) {
			chart[i] = Integer.parseInt(input[i]);
		}

		int junMoney = money;
		int junCount = 0;

		for (int day = 0; day < chart.length; day++) {
			if (chart[day] > junMoney) {
				continue;
			}

			int mul = 1;
			while (junMoney >= chart[day] * mul) {
				mul++;
			}
			junCount += --mul;
			junMoney -= chart[day] * junCount;

		}
		junMoney += chart[13] * junCount;

		int seoungMoney = money;
		int seoungCount = 0;

		// 4일치 데이터가 있어야 시작함.
		for (int day = 3; day < chart.length; day++) {
			if (chart[day] > seoungMoney) {
				continue;
			}

			if (check(chart, day) == 0) {
				int mul = 1;
				while (seoungMoney >= chart[day] * mul) {
					mul++;
				}
				seoungCount += --mul;
				seoungMoney -= chart[day] * seoungCount;
			} else if (check(chart, day) == 1) {
				seoungMoney += chart[day] * seoungCount;
				seoungCount = 0;
			} else {
				continue;
			}

		}
		seoungMoney += chart[13] * seoungCount;

		if (junMoney > seoungMoney)
			System.out.println("BNP");
		else if (junMoney < seoungMoney)
			System.out.println("TIMING");
		else
			System.out.println("SAMESAME");

	}

}
