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
		
		System.out.println(gcd(n,m));
		System.out.println(n*m/gcd(n,m));
	}

	static int gcd(int a, int b) {
		
		while(b != 0) {
			int r = a % b;
			a = b;		
			b = r;
		}
		return a;
	}
}
