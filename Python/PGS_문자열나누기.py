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
            if target == i:
                a += 1
            else:
                b += 1
            if a == b:
                answer += 1
                target = ''
                a = 0
                b = 0
        
                
    return answer