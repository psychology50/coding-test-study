import sys

n = int(sys.stdin.readline()) 
stockprice = list(map(int,sys.stdin.readline().split()))

def J():
    count = 0
    nowcash = n
    global jun_assets

    for stock in stockprice:
        count += nowcash // stock #남은 돈
        nowcash = nowcash % stock #매수가능 주식 수
            
        if nowcash == 0:
            break

    jun_assets = nowcash + count * stockprice[-1]

    return nowcash, count

def S():
    count_stock = 0
    nowcash = n
    global sung_assets

    for i in range(len(stockprice)-4):
        if(stockprice[i] < stockprice[i+1] < stockprice[i+2] < stockprice[i+3]):
            nowcash += count_stock * stockprice[i+3]
        
        elif(stockprice[i] > stockprice[i+1] > stockprice[i+2] > stockprice[i+3]):
            count_stock += nowcash // stockprice[i+3]
            nowcash = count_stock % stockprice[i+3]
        
    sung_assets = nowcash + count_stock * stockprice[-1]

    return count_stock, nowcash

J()
S()

if jun_assets > sung_assets:
    print("BNP")

elif jun_assets < sung_assets:
    print("TIMING")

else:
    print("SAMESAME")