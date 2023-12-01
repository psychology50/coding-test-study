import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] check;
    static int n;
    static int[][] node;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        int v = Integer.parseInt(sc.next());

        check = new boolean[n + 1];

        node = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());

            node[a][b] = 1;
            node[b][a] = 1;
        }

        dfs(v);
        check = new boolean[n + 1];
        System.out.println();
        bfs(v);
    }

    public static void dfs(int start) {
        check[start] = true;
        System.out.print(start + " ");
        for (int i = 1; i <= n; i++) {
            if (!check[i] && node[start][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        check[start] = true;
        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.print(start + " ");

            for (int i = 1; i <= n; i++) {
                if (!check[i] && node[start][i] == 1) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
