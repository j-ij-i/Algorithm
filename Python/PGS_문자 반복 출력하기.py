def solution(my_string, n):
    answer = ''
    for m in my_string:
        for _ in range(n):
            answer += m
    return answer