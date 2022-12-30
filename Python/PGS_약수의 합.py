from math import sqrt
def solution(n):
    answer = 0
    num = n
    for d in range(1, int(sqrt(num))+1):
        if num%d == 0:
            if not d == int(num/d):
                answer += d
                answer += int(num/d)
            else:
                answer += d
    return answer


