def solution(phone_number):
    answer = ''
    
    for i in range(len(phone_number)-4):
        answer += '*'
    
    for i in range(-1,-5,-1):
        answer += phone_number[i]
    
    return answer