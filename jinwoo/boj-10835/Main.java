import java.util.*;
import java.io.*;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        dfs(a, b, 0);
        System.out.println(result);
    }

    public static void dfs(ArrayList<Integer> a, ArrayList<Integer> b, int value) {
        if (a.isEmpty() || b.isEmpty()) {
            result = Math.max(result, value);
            return;
        }

        // 두개 다 버리기
        ArrayList<Integer> copy_a = new ArrayList<>();
        ArrayList<Integer> copy_b = new ArrayList<>();
        copy_a.addAll(a);
        copy_b.addAll(b);
        copy_a.remove(0);
        copy_b.remove(0);
        dfs(copy_a, copy_b, value);

        // 왼쪽 버리기
        copy_a = new ArrayList<>();
        copy_b = new ArrayList<>();
        copy_a.addAll(a);
        copy_b.addAll(b);
        copy_a.remove(0);
        dfs(copy_a, copy_b, value);

        // 오른쪽 버리기
        copy_a = new ArrayList<>();
        copy_b = new ArrayList<>();
        copy_a.addAll(a);
        copy_b.addAll(b);
        if (copy_a.get(0) > copy_b.get(0)) {
            int score = copy_b.remove(0);
            dfs(copy_a, copy_b, value + score);
        }
    }
}
