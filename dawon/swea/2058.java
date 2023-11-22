import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String num = br.readLine();
        String[] arr = num.split("");
        for (String s : arr) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
    }
}
