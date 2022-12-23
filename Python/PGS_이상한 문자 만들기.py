def solution(s):
    answer = ''
    flag = False
    cnt = 0
    for i in range(len(s)):
        if s[i] == ' ':
            cnt = 0
            answer += s[i]
        elif not s[i] == ' ':
            if cnt % 2 == 0:
                answer += s[i].upper()
            else:
                answer += s[i].lower()
            cnt += 1
    return answer