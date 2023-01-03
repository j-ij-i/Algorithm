def solution(s):
    answer = ''
    arr = s.split(" ")
    for i in arr:
        if len(i) > 1:
            answer += ((i[0]).upper())
            answer += (i[1:]).lower()
            answer += ' '
        elif len(i) == 1:
            answer += ((i[0]).upper())
            answer += ' '
        else:
            answer += " "
    answer = answer[:-1]
    
    return answer