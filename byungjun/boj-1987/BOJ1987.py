from collections import deque
import sys
input = sys.stdin.readline
    
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

row, col = map(int, input().split())
table = [list(input().rstrip()) for _ in range(row)]

def bfs():
    visited = [[""] * col for _ in range(row)]
    queue = deque([(0, 0, table[0][0])])

    count = 0
    while queue:
        x, y, alphabets = queue.popleft()

        if len(alphabets) > count:
            count = len(alphabets)

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < row and 0 <= ny < col and visited[nx][ny] != alphabets:
                if alphabets.find(table[nx][ny]) == -1:
                    visited[nx][ny] = alphabets
                    queue.append((nx, ny, alphabets+table[nx][ny]))
    return count

answer = bfs()
print(answer)