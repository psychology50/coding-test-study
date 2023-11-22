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
            int sum = 0;
            for(int j = 0; j < 10; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            double avg = (double) sum / 10;
            System.out.printf("#" + (i + 1) + " " + "%.0f\n", avg);
        }
    }
}
