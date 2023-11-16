import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] box = new int[N][N];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int t = 0; t < N; t++) {
					box[j][t] = Integer.parseInt(st.nextToken());
					// sb.append(box[j][t]).append(" ");
				}
				// sb.append("\n");
			}
			int sum;
			int max = 0;
			for (int j = 0; j < N-(M-1); j++) { // 1       123
				int originJ = j; // 1
				for (int t = 0; t < N-(M-1); t++) { // 2      
					int originT = t; // 2
					sum = 0;
					for (int k = 0; k < M; k++) { // 0 < 3
						for (int r = 0; r < M; r++) { // 
							sum += box[j][t]; // box[1][2] + 1 3 + 1 4 // + 2 2 + 2 3 + 2 4 // 
							// sb.append("j: ").append(j).append(", ").append("t: ").append(t).append(" = ").append(sum).append("\n");	
							j++;
						}
						t++; // 2
						j = originJ; // 1
					}
					if (max < sum) max = sum;
					// sb.append("max: ").append(max).append("\n");
					t = originT;
				}
				j = originJ;
			}
			
			sb.append("#").append(i+1).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
