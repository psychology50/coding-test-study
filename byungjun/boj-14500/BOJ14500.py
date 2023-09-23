import sys
input = sys.stdin.readline

# 일자 모양
def get_lines_sum(row, col):
    row_line_sum = 0
    col_line_sum = 0

    if row+4 <= N:
        for idx in range(4):
            row_line_sum += matrix[row+idx][col]
    
    if col+4 <= M:
        for idx in range(4):
            col_line_sum += matrix[row][col+idx]
    
    return max(row_line_sum, col_line_sum)

# ㄱ자 모양
def get_tetromino3_sum(row, col):
    max_tetro_sum = 0

    if row+3 <= N:
        row_tetro_sum = (matrix[row][col] + matrix[row+1][col] + matrix[row+2][col])

        if col+1 <= M-1:
            for r in range(row, row+3):
                max_tetro_sum = max(max_tetro_sum, row_tetro_sum + matrix[r][col+1])

        if col >= 1:
            for r in range(row, row+3):
                max_tetro_sum = max(max_tetro_sum, row_tetro_sum + matrix[r][col-1])
    
    if col+3 <= M:
        col_tetro_sum = (matrix[row][col] + matrix[row][col+1] + matrix[row][col+2])

        if row+1 <= N-1:
            for c in range(col, col+3):
                max_tetro_sum = max(max_tetro_sum, col_tetro_sum + matrix[row+1][c])
        
        if row >= 1:
            for c in range(col, col+3):
                max_tetro_sum = max(max_tetro_sum, col_tetro_sum + matrix[row-1][c])

    return max_tetro_sum

# ㄹ자 모양
def get_tetromino2_sum(row, col):
    max_tetro_sum = 0

    if row+2 <= N-1 and col+1 <= M-1:
        max_tetro_sum = max(max_tetro_sum, matrix[row][col] + matrix[row+1][col] + matrix[row+1][col+1] + matrix[row+2][col+1])
    
    if row+1 <= N-1 and col+2 <= M-1:
        max_tetro_sum = max(max_tetro_sum, matrix[row][col] + matrix[row][col+1] + matrix[row+1][col+1] + matrix[row+1][col+2])
    
    if row+2 <= N-1 and col+1 <= M-1:
        max_tetro_sum = max(max_tetro_sum, matrix[row][col+1] + matrix[row+1][col+1] + matrix[row+1][col] + matrix[row+2][col])
    
    if row+1 <= N-1 and col+2 <= M-1:
        max_tetro_sum = max(max_tetro_sum, matrix[row][col+2] + matrix[row][col+1] + matrix[row+1][col+1] + matrix[row+1][col])

    return max_tetro_sum

# 정사각형
def get_square_sum(row, col):
    square_sum = 0
    if row+2 <= N and col+2 <= M:
        for r in range(row, row+2):
            for c in range(col, col+2):
                square_sum += matrix[r][c]
    
    return square_sum

N, M = map(int, input().rstrip().split())

matrix = [list(map(int, input().rstrip().split())) for _ in range(N)]

answer = 0
for row in range(N):
    for col in range(M):
        lines_sum = get_lines_sum(row, col)
        square_sum = get_square_sum(row, col)
        tetro3_sum = get_tetromino3_sum(row, col)
        tetro2_sum = get_tetromino2_sum(row, col)

        answer = max(answer, lines_sum, square_sum, tetro3_sum, tetro2_sum)

print(answer)