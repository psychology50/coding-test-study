# BOJ 1913

"""
    입력:
    1. 홀수인 자연수
    2. 찾고자 하는 N^2 이하의 자연수

    출력:
    1. 달팽이 표
    2. 찾고자 하는 자연수의 좌표
"""

"""
    방향은 4방향으로 아래 순서대로 이동
    y+1, x+1, y-1, x-1
    
    입력받은 홀수만큼의 N*N 크기를 가짐

    방향을 기준으로 자르면 +1, -1


    y+1 방향으로 이동 시, N번 이동
    x+1, y-1 방향 이동은 N-1번 이동
    x-1, y+1 방향 이동은 N-2번 이동
    x+1, y-1 방향 이동은 N-3번 이동
    ...

    마지막 끝나는 지점은, y+1 방향으로 이동 후에 종료

    마지막에 값을 출력할때, 찾고자하는 값과 동일한 값을 출력한다면 좌표를 저장
"""

import sys
input = sys.stdin.readline

N = int(input())
find = int(input())
snail = [[0 for _ in range(N)] for _ in range(N)]

row = 0
col = 0
num = pow(N, 2)
dist = N # 이동 거리
dir = 1 # 방향
coord = -1, -1 # 찾은 좌표
while True:
    # row 이동
    for i in range(dist):
        snail[row+i*dir][col] = num
        num -= 1
    
    # col 방향으로 + dir 만큼 이동되게 한 후, 바로 시작할 수 있게
    col += dir

    # 이동거리 -1
    dist -= 1
    # 마지막 row 위치 지정
    row += dist * dir

    # 마지막은 y+1 방향 이동 후 종료
    if num == 0:
        break

    # col 이동
    for i in range(dist):
        snail[row][col+i*dir] = num
        num -= 1
    # 마지막 col 위치 지정
    col += i * dir

    # 방향 변환
    dir *= -1
    # row 방향으로 + dir(1, -1) 만큼 이동되게 한 후, 바로 시작할 수 있게
    row += dir

for i in range(N):
    for j in range(N):
        if snail[i][j] == find:
            coord = i+1, j+1
        print(snail[i][j], end=' ')
    print()
print("%d %d" % (coord[0], coord[1]))