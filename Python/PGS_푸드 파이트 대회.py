def solution(food):
    answer = ''
    
    for i in range(1,len(food)):
        a = food[i]//2
        answer += str(i)*a
    
    
    temp = (''.join(reversed(answer)))
    answer += '0'
    answer += temp
    return answer