# BOJ 17276

"""
    n*n인 2차원 정수 배열 X
    X를 45'의 배수만큼 시계방향 혹은 반시계방향으로 회전

    입력:
    1. 테스트 케이스의 수 T
    2. 각 테스트 케이스에 대해
        2-1. 배열의 크기를 나타내는 n (n은 홀수)
        2-2. 각도 d, 각도는 0 <= |d| <= 360, |d|는 5의 배수
    
    출력:
    1. 각 테스트 케이스에 대해 회전 연산을 마친 후의 배열 상태
"""

"""
    중심점을 기준으로 이동 반경이 0, 1, 2, ... 로 이동
    
    방향 이동은, 동일한 방향과, 다른 방향의 이동
    => 동일한 방향으로의 이동이 2번씩

    회전의 왼쪽, 오른쪽 두 방향이 존재 => 왼쪽 방향으로 통합 ex) 1 => -7, -1 => -1

    배열의 회전해야 하는 목록들을 → ↓ ← ↑ 으로 진행

    0 1 2
    3 4 5
    6 7 8
    배열이 있고, 왼쪽 회전이라면
    1, 2는 왼쪽 이동
    5, 8은 위로 이동
    6, 7은 오른쪽 이동
    3은 아래 이동

    마지막 0은? 따로 저장해둔 후 마지막으로
    3자리에 넣기
"""

import sys
input = sys.stdin.readline

# 역회전 (-45)
def rotate(X: list):
    size = len(X) # 크기
    
    # 회전 (0,0)부터 시작
    row = 0
    col = 0
    depth = 0 # 깊이 0 -> 1 -> 2, ...가장 안쪾까지
    dir = 1 # 방향
    move = size // 2 # 이동 횟수

    while True:
        temp = X[row][col]

        for _ in range(2):
            X[row][col] = X[row][col + move*dir] 
            col += (move * dir)
        
        for _ in range(2):
            X[row][col] = X[row + move*dir][col]
            row += (move * dir)
        
        dir *= -1
        for _ in range(2):
            X[row][col] = X[row][col + move*dir]
            col += (move * dir)
        
        for _ in range(1):
            X[row][col] = X[row + move*dir][col]
            row += (move * dir)

        X[row][col] = temp

        dir *= -1
    
        depth += 1
        row = depth
        col = depth
        move -= 1

        if move == 0:
            break

    return X

T = int(input())
X = [[] for _ in range(501)]

for _ in range(T):
    n, d = map(int, input().split())

    for i in range(n):
        X[i] = list(map(int, input().split()))
    
    # 회전 횟수
    d = d // 45
    if d > 0:
        d -= 8
    d = abs(d)
    
    if d == 0 or n == 1:
        # 각도가 0이거나, 360 일 경우 미회전
        rotated_X = X
    else:
        # 역회전(-45) * 회전 횟수
        for _ in range(d):
            rotated_X = rotate(X[:n])

    # 출력
    for i in range(n):
        for j in range(n):
            print(rotated_X[i][j], end=' ')
        print()