from collections import defaultdict
def solution(s):
    answer = []
    dic = defaultdict(int)
    
    lists = list(s)
    for i in s:
        dic[i] += 1
    for d in dic:
        if dic[d] == 1:
            answer.append(d)
    answer.sort()
    return ''.join(answer)