import java.util.Scanner;

public class BOJ14467 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int observation = in.nextInt();
				
		int[] cows = new int[10];
		boolean[] mark = new boolean[10]; // false∑Œ √ ±‚»≠ µ 
		
		int cnt = 0;
		
		for (int i = 0; i < observation; i++) {
			int n = in.nextInt();
			int location = in.nextInt();
						
			if (mark[n-1] == false) {
				mark[n-1] = true;
				cows[n-1] = location;
			}
			
			else if (cows[n-1] != location) {
				cnt++;
				cows[n-1] = location;
			}
			
		}
		
		System.out.println(cnt);
	}
}
