from collections import deque
import sys

def input():
    return sys.stdin.readline().rstrip()

#     ↑, →, ↓, ←
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

row, col = map(int, input().split())
table = [[] for _ in range(row)]
cheeze_count = 0

for y in range(row):
    table[y] = list(map(int, input().split()))
    cheeze_count += sum(table[y])

def bfs():
    air = deque([(0, 0)])
    melt = []
    visited = [[False] * col for _ in range(row)]

    while air:
        x, y = air.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
        
            if 0 <= nx < row and 0 <= ny < col and not visited[nx][ny]:
                visited[nx][ny] = True
                if table[nx][ny] == 0:
                    air.append((nx, ny))
                else:
                    melt.append((nx, ny))

    for x, y in melt:
        table[x][y] = 0

    return len(melt)

time = 0
melt_count = 0
while cheeze_count > 0:
    time += 1; melt_count = bfs()
    cheeze_count -= melt_count

print(time, melt_count, sep='\n')