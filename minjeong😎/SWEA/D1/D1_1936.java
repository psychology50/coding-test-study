import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1_1936 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a == 1 && b == 3) System.out.printf("A");
        else if (b == 1 && a == 3) System.out.printf("B");
        else if (a == 2 && b == 1) System.out.printf("A");
        else if (b == 2 && a == 1) System.out.printf("B");
        else if (a == 3 && b == 2) System.out.printf("A");
        else if (a == 2 && b == 3) System.out.printf("B");
    }
}
