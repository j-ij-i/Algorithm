def solution(order):
    answer = 0
    order = str(order)
    for i in order:
        if int(i) == 3 or int(i) == 6 or int(i) == 9:
            answer += 1
    return answer