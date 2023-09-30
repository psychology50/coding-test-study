import sys

def fibonacci(n):
    li = [0, 1]

    if n == 0:
        return li[0]
    elif n == 1:
        return li[1]
    else:
        for i in range(2, n + 1):
            li.append(li[i - 1] + li[i - 2])
        return li[n]

while True:
    num = int(input())

    if num <= 20:
        result = fibonacci(num)
        print(result)
        break
