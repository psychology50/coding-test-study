import sys
input = sys.stdin.readline

quiz = list(input().rstrip())
stack = [0]

answer = 0
current_num = 1
isAdd = True
for paren in quiz:
    if paren == ')' and stack[-1] == '(':
        if isAdd:
            answer += current_num
            isAdd = False
        current_num //= 2
        stack.pop()
    elif paren == ']' and stack[-1] == '[':
        if isAdd:
            answer += current_num
            isAdd = False
        current_num //= 3
        stack.pop()
    else:
        isAdd = True
        stack.append(paren)

        if paren == '(':
            current_num *= 2
        elif paren == '[':
            current_num *= 3

if len(stack) > 1:
    print(0)
else:
    print(answer)