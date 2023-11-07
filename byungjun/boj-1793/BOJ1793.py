import sys
input = sys.stdin.readline

dp = [1 for _ in range(251)]
dp[2] = 3
dp[3] = 5

for i in range(4, len(dp)):
    dp[i] = dp[i-1] + dp[i-2]*2

while True:
    #입력
    try: n = int(input())
    except: break

    #출력
    print(dp[n])