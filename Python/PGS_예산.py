def solution(d, budget):
    answer = 0
    d.sort()
    for i in range(len(d)):
        if answer + d[i] > budget:
            break
        else:
            answer += d[i]
    else:
        i = len(d)        
    return i