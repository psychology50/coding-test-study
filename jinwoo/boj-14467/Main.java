import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = Integer.parseInt(in.next());

        Integer[] cows = new Integer[10];
        Arrays.fill(cows, -1);

        Integer result = 0;

        for (int i = 0; i < n; i++) {
            Integer a = Integer.parseInt(in.next()) - 1;
            Integer b = Integer.parseInt(in.next());

            if (cows[a] == -1) {
                cows[a] = b;
            } else {
                if (cows[a] != b) {
                    cows[a] = b;
                    result += 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result);
        System.out.println(sb);
    }
}