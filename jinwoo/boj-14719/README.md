# 빗물

## 문제

### 설명

<img width="337" alt="image" src="https://user-images.githubusercontent.com/68031450/270497160-19576427-5193-4745-9cf8-a5c61adb1806.png">

&nbsp; 2차원 형식으로 블록이 있고, 비가 오면 블록에 물이 고이게 되는데, **고인 물의 용량(칸 수)**를 구하는 문제이다.

### 링크

- [https://www.acmicpc.net/problem/14719](https://www.acmicpc.net/problem/14719)

## 풀이

### 1. 입력

&nbsp; 우선 예제로 주어진 입력은 아래와 같다.

```
4 8
3 1 2 3 4 1 1 2
```

&nbsp; 첫 번째 줄에서 행(이하 `H`, 세로 길이)과 열(이하 `W`, 가로 길이)를 입력받는다.<br>
&nbsp; 그리고 두 번째 줄에서 각 열에 블록이 쌓인 높이를 공백으로 구분하여 입력받는다. 여기서 블록은 당연히(중력이 있으므로) 아래에서 부터 쌓인다.

![image](https://user-images.githubusercontent.com/68031450/270526905-b015a91e-0fda-4255-ba8a-0b6d1feb0d59.png)

&nbsp; 결과적으로 입력을 위한 소스 코드는 다음과 같다.

### 2. 전체 물의 양을 계산하는 방법

&nbsp; 어떻게 해야 전체 물의 양을 계산할 수 있을 지에 대해 정말 고민을 많이 했던 것 같다. 결과적으로 내가 내린 결론은 `각 열마다 반복문을 돌리고, 그 열의 행마다 반복문을 돌려서 각 열에 쌓을 수 있는 물의 양을 구하자`였다.<br>
&nbsp; 그 전에 각 열에 쌓을 수 있는 물의 양을 어떻게 구할 수 있는 지에 대해 생각해보았다.

![image](https://user-images.githubusercontent.com/68031450/270532193-4386d843-176e-4605-a0e0-457b26781465.png)

&nbsp; 우선 첫 번째 열을 보면 왼쪽에 블록이 존재하지 않기 때문에 물을 쌓을 수 없다. 그 다음 **두 번째 열에서** 파란색 선들을 좌/우로 확장시켜보면 블록이 존재한다는 것을 알 수 있다. 세 번째 열도 마찬가지이다. 그래서 나는 `특정 칸의 좌/우로 진행하다가 칸이 있을 경우 물이 채워질 수 있는 블록`이다라는 결론을 내릴 수 있었다. 작성한 코드는 아래와 같다.

```java
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
```

### 3. 다른 사람들은 어떻게 풀었을까?

&nbsp; 결과적으로 나는 3중 for문을 사용하여 문제를 해결하였으므로, 좋은 코드는 아니라는 생각이 들었고, 다른 사람들의 코드를 참고하여 수정하였다.

```java
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
```
