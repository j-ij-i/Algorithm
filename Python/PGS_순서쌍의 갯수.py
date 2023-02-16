def solution(n):
    answer = 0
    if n == 1 :
        return 1
    for i in range(1,n+1):
        if n % i == 0:
            answer += 1
    return answer