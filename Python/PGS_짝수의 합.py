def solution(n):
    answer = 0
    even = 2
    while True:
        if even > n:
            break
        answer += even
        even += 2

    
    return answer