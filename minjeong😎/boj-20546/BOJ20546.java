import java.util.Scanner;

public class BOJ20546 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int bnpBalance = in.nextInt();
		int timingBalance = bnpBalance;

		int[] cost = new int[14];

		for (int i = 0; i < 14; i++) {
			cost[i] = in.nextInt();
		}
<<<<<<< HEAD

		int bnpResult = BNP(bnpBalance, cost);
		int timingResult = Timing(timingBalance, cost);

		if (bnpResult > timingResult) {
=======
		
		for (int i = 0; i < 14; i++) {
					
			if (BNP_balance/cost[i] > 0) {
				int buying = BNP_balance/cost[i];
				BNP_cnt = BNP_cnt + BNP_balance/cost[i];
				BNP_balance = BNP_balance - buying*cost[i];
			}
						
            if (i != 0 && cost[i-1] > cost[i]) {
				down_cnt++;
			} else if (i != 0 && cost[i-1] < cost[i]) {
				up_cnt++;
			}
            
            if (down_cnt >= 3 && TIMING_balance/cost[i] > 0) {
            	int buying = TIMING_balance/cost[i];
				TIMING_cnt = TIMING_cnt + TIMING_balance/cost[i];
				TIMING_balance = TIMING_balance - buying*cost[i];
			} else if (up_cnt >= 3 && TIMING_cnt > 0) {
				TIMING_balance = TIMING_balance + TIMING_cnt*cost[i];
				TIMING_cnt = 0;
			}
            
            if (i != 13 && cost[i] <= cost[i+1]) {
				down_cnt = 0;
			}
            
            if (i != 13 && cost[i] >= cost[i+1]) {
				up_cnt = 0;
			}
            		
		
		}
		
		int BNP_result = BNP_balance + BNP_cnt * cost[13];
		int TIMING_result = TIMING_balance + TIMING_cnt * cost[13];
		
		if (BNP_result > TIMING_result) {
>>>>>>> 74e9a0d9d5f1e2a883033433b873b97998532ae3
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