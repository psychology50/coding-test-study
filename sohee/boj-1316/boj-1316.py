import sys
input = sys.stdin.readline

N=int(input())
cnt=0

for i in range(N):
    str=input().strip()
    li=list(str)
    for j in range(len(li)-1):
        if li[j] != li[j+1]:
            if li[j] in li[j+2:]:
                cnt+=1
                break   
print(N-cnt)
