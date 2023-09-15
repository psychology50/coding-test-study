import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14467 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int observation = Integer.parseInt(br.readLine());
				
		int[] cows = new int[10];
		boolean[] mark = new boolean[10]; // false로 초기화 됨
		
		int cnt = 0;
		
		for (int i = 0; i < observation; i++) {
			int n = Integer.parseInt(br.readLine());
			int location = Integer.parseInt(br.readLine());
						
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
