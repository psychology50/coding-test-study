import Foundation

let vertex = Int(readLine()!)! //컴퓨터의 갯수
let edge = Int(readLine()!)! //네트워크와 직접 연결된 컴퓨터의 쌍의 수
var graph = [[Int]](repeating: [], count:vertex+1)
var visited = [Bool](repeating: false, count:vertex+1)

for _ in 0..<edge { //네트워크 쌍만큼 입력받기
    let input = readLine()!.split(separator: " ").map { Int($0)! } //정수 여러개 입력받아서 띄어쓰기로 구분하기
    let a = input[0], b = input[1]
    graph[a].append(b)
    graph[b].append(a)
}

func dfs(node: Int) {
    visited[node] = true

    for nextNode in graph[node] {
        if !visited[nextNode] {
            dfs(node: nextNode)
        }
    }
}

dfs(node:1) //노드가 1부터 카운트
print(visited.filter {$0}.count - 1)







