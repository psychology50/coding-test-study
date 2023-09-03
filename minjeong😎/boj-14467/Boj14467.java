import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int observation = in.nextInt();
				
		int[] cows = new int[10];
		boolean[] mark = new boolean[10]; // false∑Œ √ ±‚»≠ µ 
		
		int cnt = 0;
		
		for (int i = 0; i < observation; i++) {
			int cow_num = in.nextInt();
			int location = in.nextInt();
						
			if (mark[cow_num-1] == false) {
				mark[cow_num-1] = true;
				cows[cow_num-1] = location;
			}
			
			else if (cows[cow_num-1] != location) {
				cnt++;
				cows[cow_num-1] = location;
			}
			
		}
		
		System.out.println(cnt);
	}
}
