import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 1, startIndex = 1, endIndex = 1, sum = 1;

        while (endIndex < input) {
            if (sum < input) { // 다음 수를 더기 위해 endIndex 증가
                endIndex++; // 마지막 더하기 숫자+1
                sum += endIndex; // 다음 수 더하기 (1 + 2 + 3 ...)
            } else if (sum > input) { // 연속적인 수 더하기를 했을 때 초과됨
                sum -= startIndex; // 가장 앞의 수만큼을 제거
                startIndex++; // 시작 숫자+1
            } else { // sum == input
                count++; // 카운트 증가
                endIndex++; // 마지막 숫자 증가
                sum += endIndex; // 다음 수 더하기 (1 + 2 + 3 ...)
            }
            System.out.println("sum: " + sum);
        }
        System.out.println(count);
    }
}
