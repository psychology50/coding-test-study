# BOJ1793 - 타일링

## 문제 설명

<img width="633" alt="image" src="https://user-images.githubusercontent.com/68031450/280942126-7f9fd78d-0a2e-499f-987f-5f6f45038999.png">

&nbsp; `n`이라는 숫자를 입력했을 때 `2(세로)xn(가로)`의 직사각형에 타일을 채우는 방법의 가지 수를 구하는 문제이다.

## 문제 해결 방법 선정 배경

&nbsp; 1-2년 전에 코딩테스트를 급하게 준비를 할 때 DP의 개념에 대해서 이해하고 넘어갔던 적이 있는데, 시간이 지나다보니 머릿속에서 사라져있었다.<br>
&nbsp; 다행히 지난 번 풀다만 [boj-10835](https://www.acmicpc.net/problem/10835)를 풀면서 DP에 대해 따로 [유튜브 동영상](https://youtu.be/0bqfTzpWySY?si=OeJ89ERK47mpE0ke)을 통해 학습을 했다.<br>
&nbsp; 이를 통해 이 문제는 DP 유형의 문제라고 유추하게 되었다.

## 문제 풀이

<img width="657" alt="image" src="https://user-images.githubusercontent.com/68031450/280947408-1d03f7ff-ae76-4c2e-9942-e79c68ac02d0.png">

&nbsp; `n`이 증가할 때마다 수가 얼마나 증가하는 지를 알아야 하는데, 나는 이 부분을 스스로 깨닫지 못하고 인터넷을 참고하였다. 결과적으로 `dp[n] = dp[n-1] + dp[n-2] * 2`라는 식이 성립된다고 한다. 점화식만 구하면 어렵지 않게 문제를 해결할 수 있다.<br>
&nbsp; 추가로 자바의 경우에는 int의 범위를 초과하기 때문에 Reference 타입 중 하나인 BigInteger 타입을 사용해서 문제를 풀어야 한다.

## Refrence

- [https://namhandong.tistory.com/203](https://namhandong.tistory.com/203)
