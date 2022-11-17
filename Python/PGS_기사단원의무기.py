import math
def solution(number, limit, power):
    answer = []
    for i in range(1,number+1):
        temp = 0
        sqrt = int(math.sqrt(i))

        for j in range(1,sqrt+1):
            if i%j == 0:
                temp += 2
        if sqrt*sqrt == i:
            temp -= 1
        if temp > limit:
            temp = power
        answer.append(temp)
    
    return sum(answer)