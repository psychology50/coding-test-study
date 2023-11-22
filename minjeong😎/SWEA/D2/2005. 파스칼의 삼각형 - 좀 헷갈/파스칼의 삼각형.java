import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("#").append(i).append("\n");
            int[][] tri = new int[N][];
            for (int j = 0; j < N; j++) { // 몇 번쨰 행?
            	tri[j] = new int[j+1];
        		tri[j][0] = 1;
        		sb.append(tri[j][0]).append(" ");
            	for (int k = 1; k < j; k++) { // 몇 번째 열?
            		tri[j][k] = tri[j-1][k-1] + tri[j-1][k];
            		sb.append(tri[j][k]).append(" ");
            	}
            	tri[j][j] = 1;
            	if (j != 0) 
            		sb.append(tri[j][j]).append(" ");
            	sb.append("\n");
            }
            
        }
        System.out.println(sb);

        br.close();
    }
}
