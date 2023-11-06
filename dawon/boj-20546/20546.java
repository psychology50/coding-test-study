import java.io.*;
import java.util.*;

public class 20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        int[] price = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 14; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        int jMoney = bnp(money, price);
        int sMoney = timing(money, price);

        if (jMoney > sMoney) {
            System.out.println("BNP");
        } else if (jMoney < sMoney) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    private static int bnp(int money, int[] price) {
        int stock = 0;
        for (int i = 0; i < 14; i++) {
            if (price[i] <= money) {
                int temp = money / price[i];
                money -= temp * price[i];
                stock += temp;
            }
        }
        return money + (stock * price[13]);
    }

    private static int timing(int money, int[] price) {
        int stock = 0;
        for (int i = 3; i < 14; i++) {
            if (money > 0 && price[i] < price[i - 1] && price[i - 1] < price[i - 2] && price[i - 2] < price[i - 3]) {
                int temp = money / price[i];
                money -= temp * price[i];
                stock += temp;
            }
            if (stock > 0 && price[i - 3] < price[i - 2] && price[i - 2] < price[i - 1] && price[i - 1] < price[i]) {
                money += stock * price[i];
                stock = 0;
            }
        }
        return money + (stock * price[13]);
    }
}
