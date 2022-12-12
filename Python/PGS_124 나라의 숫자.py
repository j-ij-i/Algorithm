def solution(n):    
    answer = ''
    n = int(n)
    while n > 0:
        a = n // 3
        b = n % 3
        if b == 0:
            b = 4
            a -= 1
        n = a
        answer = str(b)+answer
        
    return answer