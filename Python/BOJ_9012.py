import sys

def input():
    return sys.stdin.readline().rstrip()

T = int(input());
result = ""
for _ in range(T):
    # i가 딱히 안쓸때는 _를 사용해서 for문 구성
    testcase = input()
    stack = list()
    is_possible = True
    for i in range(len(testcase)):
        if testcase[i] == '(':
            stack.append(testcase[i])
        else:
            if not stack:
                # stack이 빌 때를 판단하기 위해 if not 사용
                is_possible = False
                break
            else:
                stack.pop()
    if not stack and is_possible:
        print('YES')
    else:
        print('NO')


# 풀이 2
import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
result = ""

for i in range(N):
    testcase = input()
    cnt = 0
    for c in testcase:
        cnt += 1 if c == '(' else -1
        if cnt < 0:
            result += "NO\n"
            break
    else:
        result += "YES\n" if cnt == 0 else "NO\n"

print(result)
