def solution(seoul):
    a = 0
    for i in range(0,len(seoul)):
        if seoul[i] == 'Kim':
            a = i
    answer = '김서방은 '+str(a)+'에 있다'
    return answer