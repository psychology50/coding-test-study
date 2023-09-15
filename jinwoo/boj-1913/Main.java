import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int d = 0;
        int dx[] = new int[]{-1, 0, 1, 0};
        int dy[] = new int[]{0, 1, 0, -1};
        
        int arr[][] = new int[n][n];
        int x = n / 2;
        int y = n / 2;
        
        int num = 1, nx = 0, ny = 0;

        arr[x][y] = num;
        if (m == num) {
            nx = x;
            ny = y;
        }
        
        while (true) {
            x += dx[d];
            y += dy[d];

            if (x < 0 || y < 0 || x >= n || y >= n) {
                break;
            }

            if (d != 3) {
                if (arr[x + dx[d + 1]][y + dy[d + 1]] == 0) {
                    d++;
                }
            } else {
                if (arr[x + dx[0]][y + dy[0]] == 0) {
                    d = 0;
                }
            }

            num++;
            arr[x][y] = num;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == m) {
                    nx = i + 1;
                    ny = j + 1;
                }

                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(nx + " " + ny);
        System.out.println(sb);

        sc.close();
    }
}