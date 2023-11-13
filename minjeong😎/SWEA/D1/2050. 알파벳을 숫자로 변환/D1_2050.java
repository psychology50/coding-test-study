import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1_2050 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine(); // ABCDEFG
        // String[] alphabet = line.split("");

        for (int i = 0; i < line.length(); i++) {
            int now = line.charAt(i); // 97->1 98->2 99->3 100->4 97은 소문자 a..^^
            int result = now - 64; // 대문자 A는 65부터

            System.out.print(String.format("%d ", result));
        }
    }
}
