import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20546 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int bnpBalance = Integer.parseInt(br.readLine());
		int timingBalance = bnpBalance;

		int[] cost = new int[14];

		for (int i = 0; i < 14; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}

		int bnpResult = BNP(bnpBalance, cost);
		int timingResult = Timing(timingBalance, cost);

		if (bnpResult > timingResult) {
			System.out.println("BNP");
		} else if (bnpResult < timingResult) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}

	}

	public static int BNP(int balance, int[] cost) {
		
		int count = 0;
		
		for (int i = 0; i < 14; i++) {
			if (balance/cost[i] > 0) {
				int buying = balance/cost[i];
				count = count + balance/cost[i];
				balance = balance - buying*cost[i];
			}
		}
		
		return balance+count*cost[13];
	}

	public static int Timing(int balance, int[] cost) {
		int count = 0;
		int upCount = 0;
		int downCount = 0;
		
		
		for (int i = 0; i < 14; i++) {
			if (i != 0 && cost[i - 1] > cost[i]) {
				downCount++;
			} else if (i != 0 && cost[i - 1] < cost[i]) {
				upCount++;
			}

			if (downCount >= 3 && balance / cost[i] > 0) {
				int buying = balance / cost[i];
				count = count + balance / cost[i];
				balance = balance - buying * cost[i];
			} else if (upCount >= 3 && count > 0) {
				balance = balance + count * cost[i];
				count = 0;
			}

			if (i != 13 && cost[i] <= cost[i + 1]) {
				downCount = 0;
			}

			if (i != 13 && cost[i] >= cost[i + 1]) {
				upCount = 0;
			}
		}
		
	return balance+count*cost[13];
	
	}
}