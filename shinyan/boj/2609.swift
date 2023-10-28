var input = readLine()!.split(separator: " ").map { Int(String($0))! } //정수 여러개 입력받아서 띄어쓰기로 구분하기

var n = input.max()!
var m = input.min()!

var k1 = 0
var temp = 0

for i in 1...10000 { //n과 m을 동시에 나눌 수 있는 수가 없을때까지 반복
    if (n%i == 0) && (m%i == 0) { //n과 m같이 나눠졌을때 나머지가 0이면 나눈 값 저장
        k1 = i; // 몫 저장
        temp = (n/i) * (m/i) * k1 
    }
} 

print(k1) //최대공약수
print(temp) //최소 공배수