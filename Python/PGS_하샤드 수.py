def solution(x):
    answer = True
    init = x
    x = list(str(x))
    x_sum = 0
    for i in x:
        x_sum+= int(i)
    if init % x_sum == 0:
        return True
    else:
        return False
    return answer