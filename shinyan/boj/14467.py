import sys

n = int(sys.stdin.readline()) #관찰횟수
count = 0
cow = [-1]*11
for i in range(n):
    a,b = map(int,sys.stdin.readline().split())
    if cow[a] == -1:
        cow[a] = b
    elif cow[a] != b:
        cow[a] = b
        count += 1

print(count)




