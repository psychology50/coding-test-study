import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Integer cash = Integer.parseInt(in.nextLine());
        
        Integer bnpMoney = cash;
        Integer bnpCount = 0;

        Integer timingMoney = cash;
        Integer timingCount = 0;

        String[] stocks = in.nextLine().split(" ");

        for (int i = 0; i < stocks.length; i++) {
            Integer stock = Integer.parseInt(stocks[i]);

            // bnp logic
            if (bnpMoney >= stock) {
                bnpCount += bnpMoney / stock;
                bnpMoney %= stock;
            }

            // timing logic
            if (i >= 3) {
                Integer preStock1 = Integer.parseInt(stocks[i - 3]);
                Integer preStock2 = Integer.parseInt(stocks[i - 2]);
                Integer preStock3 = Integer.parseInt(stocks[i - 1]);

                if (stock < preStock1 && stock < preStock2 && stock < preStock3 &&
                    preStock3 < preStock2 && preStock3 < preStock1 &&
                    preStock2 < preStock1) {
                    // 매수
                    if (timingMoney >= stock) {
                        timingCount += timingMoney / stock;
                        timingMoney %= stock;
                    }
                } else if (stock > preStock1 && stock > preStock2 && stock > preStock3 &&
                            preStock3 > preStock2 && preStock3 > preStock1 &&
                            preStock2 > preStock1) {
                    // 매도
                    timingMoney += timingCount * stock;
                    timingCount = 0;
                }
            }
        }

        // 결과 비교
        Integer bnpResult = bnpCount * Integer.parseInt(stocks[stocks.length - 1]) + bnpMoney;
        Integer timingResult = timingCount * Integer.parseInt(stocks[stocks.length - 1]) + timingMoney;
        String result = (bnpResult > timingResult) ? "BNP" : ((timingResult > bnpResult) ? "TIMING" : "SAMESAME");

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(result);
    
        System.out.println(sb);
    }
}