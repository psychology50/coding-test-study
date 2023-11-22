import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			String line = br.readLine();
			String testWord = line.substring(0, 10);
			for (int j = 1; j < 10; j++) {
				if (testWord.charAt(0) == testWord.charAt(j)) { //3
					String newTest = testWord.substring(0, j); //EXO
					if (newTest.equalsIgnoreCase(line.substring(j, 2*j))) {
						sb.append("#").append(i).append(" ").append(j).append("\n");
						break;
					}
						
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
