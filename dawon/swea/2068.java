import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int max = 0;
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(max < num) {
                    max = num;
                }
            }
            System.out.println("#" + (i + 1) + " " + max);
        }
    }
}
