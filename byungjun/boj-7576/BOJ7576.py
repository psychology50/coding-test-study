from collections import deque
import sys
input = sys.stdin.readline

col, row = map(int, input().split())
box = []

# ←, ↑, →, ↓
nx = [-1, 0, 1, 0]
ny = [0, 1, 0, -1]

completed = deque()

for r in range(row):
    row_tomato = list(map(int, input().split()))
    
    if row_tomato.count(1):
        for c in range(col):
            if row_tomato[c] == 1:
                completed.append((r, c))
    
    box.append(row_tomato)

time = 0
while len(completed) > 0:
    time += 1

    completed_size = len(completed)

    for _ in range(completed_size):
        r, c = completed.popleft()
        box[r][c] = 1

        for idx in range(4):
            next_col = c + nx[idx]
            next_row = r + ny[idx]

            if 0 <= next_col < col and 0 <= next_row < row:
                if box[next_row][next_col] == 0:
                    completed.append((next_row, next_col))
                    box[next_row][next_col] = 1

for r in range(row):
    for c in range(col):
        if box[r][c] == 0:
            print(-1)
            sys.exit(0)

print(time-1)