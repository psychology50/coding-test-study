import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1_1545 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // 3

        for (int i = num; i > -1; i--) { // 3 2 1 0
            System.out.printf("%d ", i);
        }
    }
}
