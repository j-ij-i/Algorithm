from collections import defaultdict
def solution(array, n):
    dic = defaultdict(int)
    for i in array:
        dic[i] += 1
    return dic[n]