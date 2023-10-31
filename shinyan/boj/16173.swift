import Foundation

let n = Int(readLine()!)! //게임 구역의 크기(2와 3으로 한정)
var map = [[Int]]()

for _ in 0..<n {
    let map_size = readLine()!.split(separator: " ").map {Int($0)!} //게임 구역의 크기 만큼 mapsize 입력받기 
    map.append(map_size)
}

var start = (0, 0)

var visited = [[Bool]](repeating: [Bool](repeating: false, count:n), count:n)

func dfs(_ x: Int,_ y: Int) { //구역의 크기가 2랑 3으로 밖에 제한적이지 않으니까 dfs사용함.
    visited[x][y] = true
    let dx = [map[x][y], 0]
    let dy = [0, map[x][y]]

    for i in 0..<2 {//최대가 3까지 니까
        let nx = x + dx[i]
        let ny = y + dy[i]

        if (0 <= nx && nx < n) && (0 <= ny && ny < n) && !visited[nx][ny] { //nx와 ny가 (0,0)보다 크고 오른쪽 맨 아래 칸에 도달하지 않았을 경우 dfs함수를 실행해라.
            dfs(nx, ny)
        }
    }
}

dfs(0,0)

if visited[n-1][n-1] {
    print("HaruHaru")
} else {
    print("Hing")
}
