import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] result;
		
		result = Calculator(n, m);
		
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	
	static int[] Calculator(int n, int m) {
		int x = n;
		int y = m;
		int[] divisor = new int[100];
		int[] result = {1, 1};
		
		int i = 1;
		int j = 0;
		
		while (true) {
			if (i > n || i > m || x < i || y < i) {
				break;
			}
			if (x % i == 0 && y % i == 0) {
				divisor[j] = i;
				x = x/i;
				y = y/i;
				j++;
			}
			i++;
		}
		
		for (int k = 0; k < j; k++) {
			result[0] *= divisor[k];
		}
		
		result[1] = result[0] * x * y;
		
		return result;
	}

}
