N = int(input())  
game_map = [list(map(int, input().split())) for _ in range(N)]  


def dfs(x, y):
    
    if x < 0 or y < 0 or x >= N or y >= N or game_map[x][y] == 0:
        return False
    
    if game_map[x][y] == -1:
        return True
    
    jump_distance = game_map[x][y]
    
    return dfs(x + jump_distance, y) or dfs(x, y + jump_distance)

can_win = dfs(0, 0) 

print("HaruHaru" if can_win else "Hing")
