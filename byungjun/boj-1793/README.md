# BOJ-1793

### 문제

2xn 정사각형을 2x1과 2x2 타일로 채우는 방법의 수를 구하는 문제

아래 이미지는 2x17 직사각형을 채운 한가지 예

![image](https://github.com/BangDori/RooTrip-Front/assets/44726494/b6a3df67-7dfb-4a59-83eb-7fab553a2b4c)

### 아이디어

2x1 타일을 채우는 방법 => **1가지**

2x2 타일을 채우는 방법 => **3가지**

![image](https://github.com/BangDori/RooTrip-Front/assets/44726494/1fcb6706-3127-435e-a3b3-a263c85cb69f)

2x3 타일을 채우는 방법 => **5가지**

![image](https://github.com/BangDori/RooTrip-Front/assets/44726494/5a3bdc32-4339-4894-943a-6a10494df152)

2x4 타일을 채우는 방법 => **11가지**

![image](https://github.com/BangDori/RooTrip-Front/assets/44726494/f114e235-8ed2-42f2-9d32-c33ae03dc0da)

- 2x4번 타일을 채우는 과정에서, 2x2 타일과 2x3 타일이 재활용 된다는 것을 아래 그림을 통해 확인

![image](https://github.com/BangDori/RooTrip-Front/assets/44726494/27850918-ab15-4319-90f3-ed16a9a63022)

4번 타일의 경우, 3번 타일을 이용해서 5개를 만들고, 2번 타일을 이용해서 6개를 만드는 것을 확인

공식: **`f(n) = f(n-1) + 2f(n-2)`**

위 공식을 3번 타일에 대입해보면

```
f(3) = f(2) + 2f(1)
f(3) = 3 + 2*1 = 5
```

하나만 더 확인하기 위해, 문제에서 주어지는 예제를 입력해서 확인해보자.
f(8) = 171

```
f(1) = 1
f(2) = 2
f(3) = 5
f(4) = 11
f(5) = 11 + 10 = 21
f(6) = 21 + 22 = 43
f(7) = 43 + 42 = 85
f(8) = 85 + 86 = 171
```

공식 성립! 정답!

### Wrong Answer

2x0 직사각형을 채우기 위해서는, 2x1을 0개, 2x2를 0개 사용해서 채울 수 있기 때문에

n=0일 때, 방법의 수는 1개가 되어야 함. (억까)
