import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] salePrice = new int[n];
            long money = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                salePrice[j] = Integer.parseInt(st.nextToken());
            }
            int maxPrice = 0;
            for(int j = n - 1; j >= 0; j--) {
                if(maxPrice < salePrice[j]) {
                    maxPrice = salePrice[j];
                }
                if(maxPrice > salePrice[j]) {
                    money += maxPrice - salePrice[j];
                }
            }
            System.out.println("#" + (i + 1) + " " + money);
        }
    }
}
