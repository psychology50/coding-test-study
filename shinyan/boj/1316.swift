let n = Int(readLine()!)! //단어 개수
var count = 0
for _ in 0..<n {//n만큼 단어 읽기
    let word = readLine()!
    var arr : [Character] = []
    var token = false
    for i in word {
        if !arr.contains(i) {//배열안에 문자가 포함되어있지 않을 경우 포함시켜줌
            arr.append(i)
        } else { //배열안에 문자가 들어있을 경우 
            if arr.last != i { //만약 마지막배열에 있는 문자와 i가 같지 않다면
                token = true //그룹단어 임을 체크
            }
        }
    }
    if !token {
        count += 1;
    }
}
print("\(count)")
