let nums = readLine()!.split(separator: " ").map{ Int($0)}
var arr: [Int] = []
var sum = 0

for i in 1...nums[1]! {
    for _ in 1...i {
        arr.append(i)
    }
}
for i in nums[0]!...nums[1]! {
    sum += arr[i-1]
}

print(sum)