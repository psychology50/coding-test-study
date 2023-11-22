import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1_2068 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int prior = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 9; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (prior < now) {
					prior = now;
				}
			}
			System.out.println(String.format("#%d %d", i+1, prior));
		}
		
	}

}
