import sys
input = sys.stdin.readline

def get_count(row, col, sid, size):
    like_sid_list = sid_dict.get(sid)
    like_count, empty_count = 0, 0

    if row-1 >= 0:
        if table[row-1][col] in like_sid_list:
            like_count += 1
        if table[row-1][col] == 0:
            empty_count += 1
    
    if row+1 <= size-1:
        if table[row+1][col] in like_sid_list:
            like_count += 1
        if table[row+1][col] == 0:
            empty_count += 1
    
    if col-1 >= 0:
        if table[row][col-1] in like_sid_list:
            like_count += 1
        if table[row][col-1] == 0:
            empty_count += 1
    
    if col+1 <= size-1:
        if table[row][col+1] in like_sid_list:
            like_count += 1
        if table[row][col+1] == 0:
            empty_count += 1
    
    return like_count, empty_count

size = int(input())
table = [[0 for _ in range(size)] for _ in range(size)]

sid_dict = {}

for _ in range(pow(size, 2)):
    like_sid_list = list(map(int, input().split()))
    sid = like_sid_list.pop(0)

    sid_dict[sid] = like_sid_list
    
    # 자리 배정
    max_like_count = -1
    max_empty_count = -1
    coord = (-1, -1)

    for row in range(size):
        for col in range(size):
            if table[row][col] != 0:
                continue

            isChange = False            
            like_count, empty_count = get_count(row, col, sid, size)

            if like_count > max_like_count:
                isChange = True

            if like_count == max_like_count and empty_count > max_empty_count:
                isChange = True

            if isChange:
                max_like_count = like_count
                max_empty_count = empty_count
                coord = (row, col)    
    
    table[coord[0]][coord[1]] = sid

answer = 0
for row in range(size):
    for col in range(size):
        like_count = get_count(row, col, table[row][col], size)
        answer += int(pow(10, like_count[0]-1))

print(answer)