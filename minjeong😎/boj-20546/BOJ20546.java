import java.util.Scanner;

public class BOJ20546 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int BNP_balance = in.nextInt();
		int TIMING_balance = BNP_balance;
		
		int[] cost = new int[14];
		
		int up_cnt = 0;
		int down_cnt = 0;
		
		int BNP_cnt = 0;
		int TIMING_cnt = 0;
		
		for (int i = 0; i < 14; i++) {
			cost[i] = in.nextInt();
		}
		
		for (int i = 0; i < 14; i++) {
			
			System.out.println(String.format("%d, cost[%d]: %d, BNP_balance: %d, BNP_cnt: %d, Timing_balance: %d, Timing_cnt: %d, up_cnt: %d, down_cnt: %d, TIMING_balance/cost[i]: %d", i, i, cost[i], BNP_balance, BNP_cnt, TIMING_balance, TIMING_cnt, up_cnt, down_cnt, TIMING_balance/cost[i]));
			
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
            
			System.out.println(String.format("%d, cost[%d]: %d, BNP_balance: %d, BNP_cnt: %d, Timing_balance: %d, Timing_cnt: %d, up_cnt: %d, down_cnt: %d, TIMING_balance/cost[i]: %d", i, i, cost[i], BNP_balance, BNP_cnt, TIMING_balance, TIMING_cnt, up_cnt, down_cnt, TIMING_balance/cost[i]));

		
		}
		
		int BNP_result = BNP_balance + BNP_cnt * cost[13];
		int TIMING_result = TIMING_balance + TIMING_cnt * cost[13];
		
		if (BNP_result > TIMING_result) {
			System.out.println("BNP");
		} else if (BNP_result < TIMING_result) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}

	}

}
