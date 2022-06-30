from itertools import combinations
data = input()

stack = []
array = []
answer = []

for i in range(len(data)):
    if data[i] == '(':
        stack.append(i)
    elif data[i] == ')':
        num = stack.pop()
        array.append([i,num]) # 괄호쌍을 array에 넣어주기

for i in range(1, len(array)+1): # i에 순차적으로 1부터 (len(array)+1) -1까지
    for com in list(combinations(array,i)): # array를 i 만큼 조합해서 리스트를 만들기!
        cut = []
        result = []
        for c in com: # com리스트를 하나씩 돌면서
            x, y = c  # x랑 y에 닫기 괄호, 열기 괄호를 넣는다.
            cut.append(x) # 그리고 cut하는 곳에 x와 y를 넣는다.
            cut.append(y)
        for d in range(len(data)):
            if d in cut:
                continue # 자를 문자열이면 그대로 넘기고
            else:
                result.append(data[d]) # 안자르는 문자열이면 넣기
        answer.append(''.join(result)) # 다 공백없이 합쳐주기

answer = set(answer)
answer = list(answer)
for a in sorted(answer):
    print(a)

