package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Person {
	private int money;
	private int[] chart;
	private int count;

	public Person(int money, int[] chart) {
		this.money = money;
		this.chart = chart;
		this.count = 0;
	}

	public int check(int[] check) {
		int flag = 0;

		for (int i = 0; i < check.length; i++) {
			if (check[i] == 1)
				flag++;
			else if (check[i] == 0)
				flag--;
		}

		if (flag == 3)
			return 1;
		else if (flag == -3)
			return 0;

		return -1;
	}

	public void BNP() {
		int day = 1;
		int mul = 1;
		while (true) {
			if (day == 15) {
				break;
			}
			if (money < chart[day - 1]) {
				day++;
				continue;
			}

			while (!(money < chart[day - 1] * mul)) {
				mul++;
			}
			mul--;
			money = money - chart[day - 1] * mul;

			count += mul;
			mul = 1;

			day++;
		}
	}

	public void TIMING() {
		int day = 1;
		int mul = 1;
		int[] check = new int[3];
		while (true) {
			if (day == 12) {
				break;
			}
			if (day < 4) {
				day++;
				continue;
			}
			if (money < chart[day - 1]) {
				day++;
				continue;
			}

			for (int i = 0; i < check.length; i++) {
				if (chart[(day - 1) + i] < chart[(day - 1) + i + 1]) {
					check[i] = 1;
				} else if (chart[(day - 1) + i] > chart[(day - 1) + i + 1]) {
					check[i] = 0;
				}

			}

			if (check(check) == 1) {
				while (!(money < chart[day - 1] * mul)) {
					mul++;
				}
				mul--;
				money = money - chart[day - 1] * mul;

				count += mul;
				mul = 1;

				day++;
			} else if (check(check) == 0) {
				money += chart[day - 1] * count;

				count = 0;

				day++;
			} else {
				day++;
			}

		}
	}

	public int getMoney() {
		return money + chart[13] * count;
	}

}

public class S20546 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] chart = new int[14];
		for (int i = 0; i < chart.length; i++) {
			chart[i] = Integer.parseInt(input[i]);
		}

		Person junhyeon = new Person(money, chart);
		junhyeon.BNP();
		Person sungmin = new Person(money, chart);
		sungmin.TIMING();

		if (junhyeon.getMoney() > sungmin.getMoney())
			System.out.println("BNP");
		else if (junhyeon.getMoney() < sungmin.getMoney())
			System.out.println("TIMING");
		else
			System.out.println("SAMESAME");

	}

}
