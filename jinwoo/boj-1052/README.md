# 1052번: 물병

## 문제

- [1052번: 물병](https://www.acmicpc.net/problem/1052)

## 풀이

### -1이 나올 수 있는가?

&nbsp; 문제의 출력값은 `첫째 줄에 상점에서 사야하는 물병의 최솟값을 출력한다.`이고, `만약 정답이 없을 경우에는 -1을 출력한다.`라는 내용 또한 명시되어 있다.<br>
그래서, 필요한 물병의 패턴을 구해보고자 하였다.

<img width="532" alt="image" src="https://user-images.githubusercontent.com/68031450/272462375-2fac805a-e42d-4984-806f-ea3fde3ba600.png">

&nbsp; 위 그림을 그려보면서 느낀 결론은 다음과 같다. `물병의 개수가 2의 제곱일 경우 1개로 합칠 수 있다.`, 고로 `물병의 개수가 무제한이라는 가정 하에 원하는 숫자 이하로 물병을 합칠 수 있다.` 즉 `-1`을 출력할 경우는 존재하지 않는다는 것이다.

### 핵심 로직

```java
while (Integer.bitCount(n) > k) {
    answer += n & (-n);
    n += n & (-n);
}
```

- `while (Integer.bitCount(n) > k)` : n을 이진수로 바꾼 후, n의 비트 중 1인 비트의 개수가 k보다 큰 동안에만 While 루프를 반복한다.
- `answer += n & (-n)` : n과 -n의 비트 AND 연산을 수행한 값을 더한다.
- `n += n & (-n)` : n과 -n의 비트 AND 연산을 수행한 값을 더한다.

## 전체 소스 코드

```java
import java.util.*;
import java.io.*;

class Main {
    private static int n;
    private static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int answer = 0;

        while (Integer.bitCount(n) > k) {
            answer += n & (-n);
            n += n & (-n);
        }

        System.out.println(answer);
    }
}
```

## 참고

- [https://katastrophe.tistory.com/147](https://katastrophe.tistory.com/147)
