import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sec\\Downloads\\input.txt"));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int turn = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] cnt = new int[101];
			// Arrays.fill(cnt, 0);
			int max = 0;
			int maxNum = 0;
			for (int j = 0; j < 1000; j++) {
				int score = Integer.parseInt(st.nextToken()); // 시험 점수
				
				if (cnt[score] > 0) {
					cnt[score]++;
				} else {
					cnt[score] = 1;
				}
				
				if (max < cnt[score]) {
					max = cnt[score];
					maxNum = score;
				}
			}
			
			for (int j = 0; j < 100; j++) {
				if (max == cnt[j] && maxNum < j) 
					maxNum = j;
			}
			
			sb.append("#").append(turn).append(" ").append(maxNum).append("\n");
		}
		
		System.out.println(sb);
	}

}
