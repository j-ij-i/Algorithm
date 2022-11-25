from collections import defaultdict
def solution(k, tangerine):
    answer = 0
    dic = defaultdict(int)
    for i in tangerine:
        dic[i] += 1
    sorted_d = sorted(dic.items(), key=lambda x: x[1], reverse=True)
    for i,j in sorted_d:
        k = k-j
        answer += 1
        if k <= 0:
            break       
    
    return answer