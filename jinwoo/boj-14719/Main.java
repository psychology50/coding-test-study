import java.util.*;
import java.io.*;

class Main {
    private static int h;
    private static int w;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 1; i < w - 1; i++) {
            int cur = arr[i];
            int left = cur;
            int right = cur;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > cur) {
                    left = Math.max(left, arr[j]);
                }
            }

            for (int j = i + 1; j < w; j++) {
                if (arr[j] > cur) {
                    right = Math.max(right, arr[j]);
                }
            }

            if (cur < left && cur < right) {
                result += Math.min(left, right) - cur;
            }
        }

        System.out.println(result);
    }
}