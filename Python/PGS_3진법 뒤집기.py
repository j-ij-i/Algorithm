def solution(n):
    answer = 0
    res = ''
    while n >= 3:
        l = n % 3
        n = n // 3
        res = str(l) + res
    res = list(str(n) + res)
    
    for i in range(len(res)):
        answer += int(res[i])*(3**i)
    
    return answer
