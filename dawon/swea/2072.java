import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int[] num = new int[10];
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 10; j++) {
                num[j] = Integer.parseInt(st.nextToken());
                if(num[j] % 2 == 1) {
                    sum += num[j];
                }
            }
            System.out.println("#" + (i + 1) + " " + sum);
        }
    }
}
