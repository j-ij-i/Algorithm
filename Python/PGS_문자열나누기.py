from collections import defaultdict
def solution(s):
    answer = 0
    dic = defaultdict(int)
    target = ''
    a = 0
    b = 0
    for i in s:
        if target == '':
            target = i
            a += 1
        else:
            if i == target:
                a += 1
            else:
                b += 1
            if a == b:
                answer += 1
                print(i)
                target = ''
                a = 0
                b = 0
                
    if not target == '':
        answer += 1
    return answer