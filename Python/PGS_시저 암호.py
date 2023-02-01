def solution(s, n):
    answer = ''
    for i in s:
        if i.isalpha():
            if i.isupper() and (ord(i)+n)>=91:
                answer += chr((ord(i)+n-91)+65)
            elif i.islower() and (ord(i)+n)>=123:
                answer += chr((ord(i)+n-123)+97)
            else:
                answer += chr(ord(i)+n)
        else:
            answer += i
    return answer