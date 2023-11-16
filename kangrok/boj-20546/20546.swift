let money = Int(readLine()!)!

let chart = readLine()!.split(separator: " ").map { Int($0)! }

var J: (money: Int, stock: Int) = (money, 0)
var S: (money: Int, stock: Int) = (money, 0)
var downCount = 0
var upCount = 0

for i in 0..<chart.count {
  if i != 0 {
    if chart[i] > chart[i-1] {
      upCount += 1
      downCount = 0
    } else if chart[i] == chart[i-1] {
      upCount = 0
      downCount = 0
    } else {
      downCount += 1
      upCount = 0
    }
  }
  
  if J.money >= chart[i] {
    J.stock += J.money / chart[i]
    J.money -= J.money / chart[i] * chart[i]
  }
  
  if downCount >= 3 && S.money >= chart[i] {
    S.stock += S.money / chart[i]
    S.money -= S.money / chart[i] * chart[i]
  }
  
  if upCount >= 3 && S.stock > 0 {
    S.money += S.stock * chart[i]
    S.stock = 0
  }
  
  if i == 13 {
    if J.money + J.stock * chart[i] > S.money + S.stock * chart[i] {
      print("BNP")
    } else if J.money + J.stock * chart[i] < S.money + S.stock * chart[i] {
      print("TIMING")
    } else {
      print("SAMESAME")
    }
  }
}
