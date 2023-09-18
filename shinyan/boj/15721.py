import sys

A = int(sys.stdin.readline()) #게임을 진행하는 사람
T = int(sys.stdin.readline()) #구하고자 하는 번째
n = int(sys.stdin.readline()) #구하고자 하는 구호 0->뻔, 1->데기

bundegi = []
b = d = 1 #번데기 외친 횟수
turncount = 0 #턴 횟수

for _ in range(T): #구하고자 하는 번째가 될 때까지 반복
    #thisturn = b #항상 뻔 먼저 시작하니까
    turncount += 1 #턴횟수 카운트 시작

    for _ in range(2): #처음에 시작할 때 뻔-데기-뻔-데기 후에 시작됨
        bundegi.append((b,0)) #뻔 -> 0
        b+=1 #뻔
        bundegi.append((d,1)) #데기 -> 1
        d+=1 #데기
    
    for _ in range(turncount + 1): #턴이 돌수록의 뻔
        bundegi.append((b,0))
        b+=1

    for _ in range(turncount + 1):
        bundegi.append((d,1))
        d+=1

    if  T <= b:
        print("=====")
        print(bundegi.index((T,n)) % A)
        break

