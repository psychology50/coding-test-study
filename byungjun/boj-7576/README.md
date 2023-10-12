# BOJ-7576

### 문제 설명

문제: 박스 내에 모든 토마토를 익게 하는데 걸리는 **최소 시간** 구하기

박스에 토마토의 상태가 존재(-1, 0, 1)

```
-1: 토마토가 들어가 있지 않은 칸
0: 익지 않은 토마토가 있는 칸
1: 익은 토마토가 있는 칸
```

익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향

- 이때, 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미

### 아이디어

1. 방향 검사를 위해 nx, ny 설정
   ```
         ←, ↑, →, ↓
   nx = [-1, 0, 1, 0]
   ny = [0, 1, 0, -1]
   ```
2. 익은 토마토가 존재하는 부분을 배열에 저장
3. 배열에 아직 익지 않은 토마토가 존재할 때 까지 순회
   - 날짜를 기준으로 익은 토마토 주변이 모두 영향을 받기 때문에 **너비 우선 탐색** 이용
   - 익은 토마토를 기준으로 4방향을 확인
   - 익은 토마토가 존재한다면 배열에 삽입
   - 배열을 순회할 때 마다, 시간+1
4. 순회가 종료된 후에, 박스를 확인
   - 박스에 익지 않은 토마토(0)이 하나라도 존재한다면 -1을 출력
   - 박스에 익지 않은 토마토가 존재하지 않는다면 시간을 출력

![image](https://github.com/BangDori/ci-cd-test/assets/44726494/31e695ba-9cd2-49ff-b88f-2d35d046dc7d)

### Memory Limit Exceeded 발생한 부분

```
for r, c in completed:
    box[r][c] = 1

    for idx in range(4):
        next_col = c + nx[idx]
        next_row = r + ny[idx]

        if 0 <= next_col < col and 0 <= next_row < row:
            if box[next_row][next_col] == 0:
                next_completed.append((next_row, next_col))
```

다음 날 익는 토마토에 대해 1을 미리 저장해두지 않으면 **중복되게 저장**하는 경우가 발생

```
        if 0 <= next_col < col and 0 <= next_row < row:
            if box[next_row][next_col] == 0:
                next_completed.append((next_row, next_col))
                box[next_row][next_col] = 1
```

다음에 순회할 배열을 저장할 때 그 값을 1로 설정하고 저장

### Time Limit Exceeded 발생한 부분

```
while len(completed) > 0:
   # ...

    for _ in range(completed_size):
        r, c = completed.pop(0)

   # ...
```

`pop(0)`의 경우 젤 첫번째 원소를 삭제한 후, 모든 원소를 앞으로 당기는 작업이 발생하기 때문에 **O(n)** 만큼의 시간 복잡도가 발생
=> `deque`의 `popLeft()`를 이용하여 **O(1)** 의 시간복잡도로 해결
