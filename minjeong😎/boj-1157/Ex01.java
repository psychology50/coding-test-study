import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String line = in.next();
		
		// String[] word = line.toLowerCase().split("");
		char[] charArray = line.toLowerCase().toCharArray();
		
		int[] cnt = new int[26];
		// hello
		int max = 0;
		boolean equal = false;
				
		for (int  i = 0; i < charArray.length; i++) {
			for (int j = 97; j <= 122; j++) {
				if (charArray[i] == j) {
					System.out.println(String.format("charArray[%s] = %s , j = %s", i, charArray[i], j));
					cnt[j-97]++;
					System.out.println(String.format("cnt[%s]++ = %s", j-97, cnt[j-97]));
				
					if (cnt[j - 97] > max) {
						max = cnt[j - 97];
						equal = false;
					} else if(cnt[j-97] == max) {
						equal = true;
					}
				}
			}
		}
		
		if (equal == true) {
			System.out.println("?");
		}
		else {
			System.out.println(max);
		}
		
	}
	
}
