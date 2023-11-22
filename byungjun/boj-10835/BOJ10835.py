import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

cards = int(input())
left_cards = list(map(int, input().split()))
right_cards = list(map(int, input().split()))

answer = 0
dp = [[-1] * cards for _ in range(cards)]

def dfs(l, r, point):
    if l == cards or r == cards:
        return point
    
    if dp[l][r] != -1:
        return dp[l][r]
    
    if left_cards[l] > right_cards[r]:
        dp[l][r] = dfs(l, r+1, point) + right_cards[r]
    else:
        throw_left = dfs(l+1, r, point)
        throw_all = dfs(l+1, r+1, point)

        dp[l][r] = max(throw_left, throw_all)
    
    return dp[l][r]

dfs(0, 0, 0)
print(dp[0][0])