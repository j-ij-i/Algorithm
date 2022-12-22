def solution(s):
    answer = ''
    flag = False
    cnt = 0
    for i in range(len(s)):
        if not flag and s[i] == 0:
            answer += s[i]
        elif not flag and not s[i] == 0:
            flag = True
            cnt = 0
            print(s[i])
            answer += (s[i].upper())
            cnt += 1
        elif flag:
            if cnt % 2 == 0:
                answer += (s[i].upper())
            else:
                answer += (s[i].lower())
            cnt += 1
    return answer