import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1_1933 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.printf("%d ", i);
            }
        }
    }
}
