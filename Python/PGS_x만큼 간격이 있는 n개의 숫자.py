def solution(x, n):
    answer = []
    init_x = x
    while n > 0:
        answer.append(x)
        x += init_x
        n -= 1
    return answer