import java.util.*;
import java.io.*;

class Main {
    private static int h;
    private static int w;
    private static int[][] arr;

    private static final int BLOCK = 2;
    private static final int WATER = 1;
    private static final int NULL = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new int[h][w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = h - 1; j >= h - height; j--) {
                arr[j][i] = 2;
            }
        }

        int result = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w - 1; j++) {
                if (arr[i][j] == BLOCK)
                    continue;

                int left = j;
                int right = j;

                for (int k = j - 1; k >= 0; k--) {
                    if (arr[i][k] == BLOCK || arr[i][k] == WATER) {
                        left = k;
                        break;
                    }
                }

                for (int k = j + 1; k < w; k++) {
                    if (arr[i][k] == BLOCK || arr[i][k] == WATER) {
                        right = k;
                        break;
                    }
                }

                if (left < j && right > j) {
                    arr[i][j] = WATER;
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}