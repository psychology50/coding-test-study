import sys
input = sys.stdin.readline

size, ans_row, ans_col = map(int, input().split())
count = 0
answer = 0

def get_Z(size, row, col):
    if size == 1:
        global count

        if ans_row == row and ans_col == col:
            answer = count
        elif ans_row == row and ans_col == col+1:
            answer = count + 1
        elif ans_row == row+1 and ans_col == col:
            answer = count + 2
        else:
            answer = count + 3
        print(answer)
        return

    if ans_row < row+pow(2, size-1) and ans_col < col+pow(2, size-1):
        # 1
        get_Z(size-1, row, col)
    elif ans_row < row+pow(2, size-1):
        # 2
        count += (pow(2, size-1) * pow(2, size-1))
        get_Z(size-1, row, col+pow(2, size-1))
    elif ans_col < col+pow(2, size-1):
        # 3
        count += (pow(2, size-1) * pow(2, size-1) * 2)
        get_Z(size-1, row+pow(2, size-1), col)
    else:
        # 4
        count += (pow(2, size-1) * pow(2, size-1) * 3)
        get_Z(size-1, row+pow(2, size-1), col+pow(2, size-1))

get_Z(size, 0, 0)