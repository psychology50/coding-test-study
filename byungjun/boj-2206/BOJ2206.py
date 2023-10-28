from collections import deque
import sys
input = sys.stdin.readline

#     →, ↓, ←, ↑
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

x, y = map(int, input().split())
matrix = [list(input().rstrip()) for _ in range(x)]
matrix[0][0] = 2

pos = deque([(0, 0, 0)])
dist = 0
answer = 0

while len(pos) > 0:
    dist += 1
    size = len(pos)

    for _ in range(size):
        cur_x, cur_y, break_count = pos.popleft()

        if cur_x == x-1 and cur_y == y-1:
            matrix[x-1][y-1] = 2
            answer = dist
            pos.clear()
            break

        for i in range(4):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]

            if 0 <= nx < x and 0 <= ny < y:
                if matrix[nx][ny] == '0':
                    if break_count == 1:
                        matrix[nx][ny] = '3'
                    else:
                        matrix[nx][ny] = '2'
                    pos.append((nx, ny, break_count))

                if matrix[nx][ny] == '3':
                    if break_count == 0:
                        matrix[nx][ny] = '2'
                        pos.append((nx, ny, break_count))

                if matrix[nx][ny] == '1' and break_count == 0:
                    pos.append((nx, ny, 1))

if matrix[x-1][y-1] == 2:
    print(answer)
else:
    print(-1)