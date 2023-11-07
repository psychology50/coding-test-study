var sum = 0
var arr: [Int] = []
var selectArr: [Int] = []

for _ in 1...9 {
    let input = Int(readLine()!)!
    arr.append(input)
    sum += input
}
for i in 0..<arr.count {
    for j in i+1..<arr.count {
        if sum - (arr[i] + arr[j]) == 100 {
            selectArr = arr.filter { $0 != arr[i] && $0 != arr[j] }
            break
        }
    }
}
for dwarf in arr {
    if selectArr.contains(dwarf) {
        print(dwarf)
    }
}

