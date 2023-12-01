import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 트리 깊이 받이
        int nodeCount = (int) (Math.pow(2, k) - 1); // 트리의 노드 개수
        int[] arr = new int[nodeCount]; // 배열 만들기
        int num = -1;
        for (String str : br.readLine().split(" ")) {
            arr[++num] = Integer.parseInt(str);
        }
        String answer = "";
        int start = 0;
        int b = 2;
        for (int i = 0; i < k; i++) {
            String result = "";
            for (int j = start; j < nodeCount; j += b) {
                result += arr[j] + " ";
            }
            result += "\n";

            answer = result + answer;
            // 1 3 5 6 9 11 13 15
            // 2 6 10 14
            // 4 12
            // 8
            start = start * 2 + 1;
            b *= 2;
        }

        System.out.println(answer);
    }
}
