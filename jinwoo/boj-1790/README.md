# 수 이어 쓰기 2

## 문제

[https://www.acmicpc.net/problem/1790](https://www.acmicpc.net/problem/1790)

## 풀이

&nbsp; `수학`, `구현`으로 분류되어 있는 골드 5 난이도의 문제이다.

### 접근 방식 1 : 문자열을 전부 이어 붙인 후 해당 글자로 구하기

```java
import java.util.*;
import java.io.*;

class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long target = 0;
        long len = 1;
        long cnt = 9;

        while (K > (len * cnt)) {
            K -= (len * cnt);
            target += cnt;
            len++;
            cnt *= 10;
        }

        target += ((K - 1) / len) + 1;
        
        if (target > N) {
            System.out.println(-1);
        } else {
            int idx = (int) ((K-1) % len);
            System.out.println(String.valueOf(target).charAt(idx));
        }

        br.close();
    }
}
```

&nbsp; 우선 가장 직관적인 방법을 시도해보았다. 1부터 n까지의 숫자가 있다면 그 문자를 `StringBuilder`를 통해 모두 연결하고, `charAt` 메서드를 통해 해당 위치의 문자를 출력하도록 구현해보았다.

<img width="1083" alt="image" src="https://user-images.githubusercontent.com/68031450/268772852-008ce4ba-ec78-473c-ab31-f49c8802860b.png">

&nbsp; `메모리 초과`가 발생하였다. 사실 골드5 쯤 되면 이런 방법으로는 풀 수 없다는 것을 알고는 있었지만, 그래도 자바의 입출력 방식과 친해질 겸 한 번 시도해보고 싶었다.

### 접근 방식 2 : 규칙 이해

&nbsp; `방식 1`의 실패로 다른 방식을 찾아야 했다. 30분 정도 고민해보았으나 시간 관계 상 다른 사람의 코드를 참고하고 내 것으로 만들고자 한다.

#### 규칙

|자리 수(`len`)|숫자 개수(`cnt`)|글자 길이(`target`)|
|---|---|---|
|1(1~9)|9개|9개|
|2(10~99)|90개|180개|
|3(100~999)|900개|2700개|
|4(1000~9999)|9000개|36000개|
|...|...|...|

&nbsp; 위의 표는 각 자리 수에 따른 숫자의 갯수와 숫자를 모두 이어 붙였을 때 나오는 글자의 길이를 의미한다.

![image](https://user-images.githubusercontent.com/68031450/269174887-9f165c03-a1ba-49f0-b64e-ad67e327de42.png)

&nbsp; 프로그램 프로세스를 순차적으로 살펴보자.

1. 입력 받기
2. 계산을 위한 초기값 설정
    - target: K에 해당하는 숫자를 찾기 위한 변수
    - len: K에 해당하는 숫자의 글자 수를 저장하기 위한 변수
    - cnt: 글자 수에 해당하는 숫자 범위를 저장하기 위한 변수
3. `K`에서 자리 수만큼 필요한 숫자를 빼면서 찾아야 할 숫자를 줄임
4. `target`에 자리 수만큼 필요한 숫자를 더함
5. `len(자릿수)`++
6. `cnt *= 10` : 자릿수에 필요한 숫자를 저장
7. `target += ((K - 1) / len) + 1` : while 문을 빠져 나온 후 `K`의 초기값에서 빼고 남은 `K`에서 자릿수만큼을 나눔으로써 `K` 초기값으로 찾고자 했던 자리 수에 해당하는 전체 숫자 구하기
8.

- 참고한 블로그
  - [https://code-lab1.tistory.com/145](https://code-lab1.tistory.com/145)
  - [https://jaeseo0519.tistory.com/10](https://jaeseo0519.tistory.com/10)

#### 유의사항

- 변수 `target`과 `len`, `cnt`의 타입을 `long`으로 선언하여야 한다

  - 변수 `K`의 범위가 `1 이상 1,000,000,000 이하`인데 이 세 개의 변수는 변수 `K`를 다루기 때문에, `int`로 사용할 경우 최대값인 `2,147,483,647`를 넘어서 오답으로 출력된다.

    <img width="770" alt="image" src="https://user-images.githubusercontent.com/68031450/269176010-c434b79f-ee15-40a8-8e82-f35fe17e6178.png">
