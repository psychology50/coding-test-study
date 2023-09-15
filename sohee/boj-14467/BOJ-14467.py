# Observation_Count = int(input())
# count = 0

# for i in range(0,Observation_Count):
#      Cow_Number, Position = input().split()

# for i in range(0,Observation_Count):
#      if

import sys
input = sys.stdin.readline

observ = {}
cnt = 0
for _ in range(int(input())):
    cow, dir = map(int, input().split())
    if cow in observ.keys():
        if observ[cow] == dir:
            continue
        else:
            observ[cow] = dir
            cnt += 1
    else:
        observ[cow] = dir
print(cnt)