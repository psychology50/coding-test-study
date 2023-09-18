import sys
input = sys.stdin.readline

A = int(input())    
T = int(input())   
S = int(input())    

bcount = 0     
gcount = 0     

cnt = 0         

N = []          

while True:

    cnt += 1

    for _ in range(2):
        bcount += 1
        N.append((bcount, 0))
        gcount += 1
        N.append((gcount, 1))
    for _ in range(cnt + 1):
        bcount += 1
        N.append((bcount, 0))
    for _ in range(cnt + 1):
        gcount += 1
        N.append((gcount, 1))

    if bcount >= T:
        print(N.index((T, S)) % A)
        break
