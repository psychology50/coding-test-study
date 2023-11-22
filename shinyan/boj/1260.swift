import Foundation

var input = readLine()!.split(separator: " ").map { Int(String($0))! } //정수 여러개 입력받아서 띄어쓰기로 구분하기

let n = input[0] //정점
let m = input[1]  //간선
let v = input[2] //시작 정점

var visited = [Bool](repeating: false, count: n+1)
var graph = [[Int]](repeating: [], count:n+1)

for _ in 0..<m {
    let input = readLine()!.split(separator:" ").map {Int($0)!}
    let a = input[0], b = input[1]
    graph[a].append(b)
    graph[b].append(a)
}

graph = graph.map { $0.sorted() }

func dfs(node: Int) {
    visited[node] = true
    print(node, terminator: " ")

    for nextNode in graph[node] {
        if !visited[nextNode] {
            dfs(node: nextNode)
        }
    }
}

func bfs(node: Int) {
    var queue = [node]
    var index = 0
    visited[node] = true
    while queue.count > index {
        let currentNode = queue[index]
        print(currentNode, terminator: " ")

        for nextNode in graph[currentNode] {
            if !visited[nextNode] {
                visited[nextNode] = true
                queue.append(nextNode)
            }
        }
        index += 1
    }
}

dfs(node: v)
visited = [Bool](repeating: false, count: n+1)
print()
bfs(node: v)