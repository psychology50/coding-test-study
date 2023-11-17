import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
	// long 타입 때문에 고생했다.. int로 안될 때는 long 타입!!
	
	static long max = 0;
	static int maxNum = 0;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// PrintWriter pw = new PrintWriter("C:\\Users\\samsung\\Downloads\\result.txt");
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// ArrayList<Integer> list = new ArrayList<>();
			int[] list = new int[num];
			
			for (int j = 0; j < num; j++) {
				list[j] = Integer.parseInt(st.nextToken());
				if (max <= list[j]) { max = list[j]; maxNum = j;}
			}
			
			// sb.append("max: ").append(max).append(" maxNum: ").append(maxNum).append("\n");
			
			long stock = 0;
			long budget = 0;
			
			for (int j = 0; j < num; j++) {
				
				if (j == maxNum) { // 최대 금액이랑 today가 같음
					// sb.append("j: ").append(j).append(" ----sell----").append("\n");
					budget += stock * list[j];
					stock = 0;
					// sb.append(budget).append(" ").append(stock).append("\n");
					// find new maxNum
					max = 0;
					for (int t = j+1; t < num; t++) {
						if (max <= list[t]) { max = list[t]; maxNum = t;}
					}
					// sb.append("new max: ").append(max).append(" new maxNum: ").append(maxNum).append("\n");
				}
				else {
					// sb.append("j: ").append(j).append(" ----buy----").append("\n");
					budget -= list[j];
					stock++;
					// sb.append(budget).append(" ").append(stock).append("\n");
				}
			}
			sb.append(budget).append("\n");
		}

		System.out.println(sb);
		// pw.println(sb);
		// pw.close();
	}
}
