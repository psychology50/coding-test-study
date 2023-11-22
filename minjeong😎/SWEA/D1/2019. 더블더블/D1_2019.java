import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1_2019 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int i = 1;
        System.out.printf("%d ", i);
        while (num > 0) {
            i *= 2;
            System.out.printf("%d ", i);
            num--;
        }
    }
}
