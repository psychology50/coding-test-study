import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15721 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine()); // 識 賃 貲
		int t = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		System.out.println(play(a, t, c));
		
	}
	
	static int play(int a, int t, int c) {
		int n = 2;
		int cnt1 = 0; // 遠 cnt
		int cnt2 = 0; // 等晦 cnt
		
		while(true) {
			
			// 遠-等晦-遠-等晦
			for (int i = 0; i < 4; i++) {
				if (i%2==0)
					cnt1++;
				else cnt2++;
				if (cnt1==t && c==0) {
					return (cnt1+cnt2-1)%a;
				}
				if (cnt2==t && c==1) {
					return (cnt1+cnt2-1)%a;
				}
			}
			
			// n�蜃� (遠*n+1)
			for (int i = 0; i < n; i++) {
				cnt1++;
				if (cnt1==t && c==0) {
					return (cnt1+cnt2-1)%a;
				}
			}
			
			for (int i = 0; i < n; i++) {
				cnt2++;
				if (cnt2==t && c==1) {
					return (cnt1+cnt2-1)%a;
				}
			}
			
			n++;
		}

	}

}
