# 카드게임(boj-10835)

## 기존 해결법 (DFS)

```java
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
```

&nbsp; 기존에는 모든 경우의 수를 체크하기 위해 DFS를 통해 문제를 해결하려고 하였다. ArrayList를 사용하였고, 이를 deep-copy하여 재귀 함수를 호출하였지만 이 방식으로는 1솔이 아닌 0.3솔(부분 점수 31점)에 그쳤다.

<img width="739" alt="image" src="https://user-images.githubusercontent.com/68031450/282366571-5a5a12ef-7a42-4404-b4f8-a685b44c0f71.png">

## DP를 이용한 풀이

&nbsp; 그래서 이 문제는 DP로 이전 값을 캐싱하여 풀어야 한다는 생각을 하게 되었다. 이를 위해서 기저사례에 대해서 우선 생각해보았고, 결론은 `왼쪽 혹은 오른쪽의 카드가 모두 떨어졌을 경우`라는 결론에 도달하였다.<br>

... 작성 중 ...
