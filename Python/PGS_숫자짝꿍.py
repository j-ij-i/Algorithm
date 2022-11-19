from collections import defaultdict
def solution(X, Y):
    answer = []
    
    xdic = [0 for _ in range(10)] 
    ydic = [0 for _ in range(10)]
    
    for i in X:
        xdic[int(i)] += 1
    for i in Y:
        ydic[int(i)] += 1
        
    for i in range(9,-1,-1):
        m = min(xdic[i], ydic[i])
        n = str(i)
        answer.append(n*m)
        
    answer = ''.join(answer)
    if answer == '':
        answer = '-1'
    elif answer.count('0') == len(answer):
        answer = '0'

    return answer