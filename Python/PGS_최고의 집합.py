def solution(n, s):
    answer = [s//n] * n
    rem = s%n
    
    for i in range(rem):
        answer[i] +=1
    answer.sort()
    
    if answer[0] == 0:
        return [-1]
    else:
        return answer