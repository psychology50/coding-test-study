# BOJ 14719

"""
    고이는 빗물의 총량을 구하기

    입력:
    1. 2차원 세계의 세로 길이 H와 가로 길이 W
    2. 두 번째 줄에는 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W

    조건:
    1 <= H, W <= 500
    블록 배누의 빈 공간이 생길 수 없으며, 2차원 세계의 바닥은 항상 막혀있음

    출력:
    고이는 빗물의 총량 (만약 전혀 고이지 않을 경우 0)
"""

"""
    높이들을 비교, 바닥은 막혀있지만 좌우는 막혀있지 않음

    즉, 입력받은 높이들 간에 공간이 있어야함
    ex) 3 2 1 3 => 2, 1이 3과 3이라는 벽 사이의 공간에 갇혀있음

    벽과 벽 사이의 공간의 기준

    우선 첫번째와, 마지막은 벽에 포함 (0 이라면 벽이 아님)
    배열을 순회하면서, 다음 벽이 증가하는 순간이 기준 => 기준들을 standard 배열에 저장
    벽 A, B 사이의 공간에 있는 벽돌들은 min(A, B) 만큼 빗물이 차게 됨

    ex) 만약 3 2 1 2 1 3 이라면 => 3(0번째) 2(3번째) 3(마지막)이 기준으로 잡힘
        이는 우리가 의도한 답이 아니므로 빗물을 채우기를 반복
        => 이전 블록들과, 현재 블록들이 같아질 때 까지

        1번째 반복문 -> 3 2 2 2 2 3
        2번째 반복문 -> 3 3 3 3 3 3
        3번째 반복문 -> 3 3 3 3 3 3 (탈출)
"""

import sys
input = sys.stdin.readline

h, w = map(int, input().split())

blocks = list(map(int, input().split()))
prev_blocks = []
standard = []
answer = 0

while True:
    prev = 0
    for idx in range(len(blocks)):
        if blocks[idx] > prev:
            standard.append(idx)
        prev = blocks[idx]

    if prev_blocks == blocks:
        break
    prev_blocks = blocks.copy()

    if len(standard) > 1:
        cur = 0
        while True:
            if cur+1 == len(standard):
                break

            start = standard[cur]
            end = standard[cur+1]
            least = min(blocks[start], blocks[end])

            for i in range(start+1, end):
                if least - blocks[i] >= 0:
                    answer += least - blocks[i]
                    blocks[i] = least
            
            cur += 1
        
        standard.clear()
    else:
        break

print(answer)