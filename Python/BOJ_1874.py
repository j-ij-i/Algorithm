
import sys

N = int(input())

stack = []
# 숫자 들어 오는 곳
result = []
# + - 입력 하는 곳
flag = True
a = 1
for _ in range(N):
    i = int(input())
    while a <= i:
        stack.append(a)
        result.append('+')
        a += 1
    if stack[-1] == i:
        stack.pop()
        result.append('-')
    else:
        flag = False
        break

if flag == False:
    print('NO')
else:
    for n in result:
        print(n)
