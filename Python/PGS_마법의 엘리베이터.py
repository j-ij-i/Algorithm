def solution(storey):
    answer = 0
    storey = list(str(storey))
    
    for i in range(len(storey)-1, 0, -1):
        if storey[i]=='0':
            continue
        elif storey[i]=='10':
            storey[i-1] = int(storey[i-1])+1
            continue
        else:
            if int(storey[i]) < 5:
                answer += int(storey[i])
                storey[i] = '0'
            elif int(storey[i]) == 5:
                if int(storey[i-1]) >= 5:
                    storey[i-1] = str(int(storey[i-1])+1)
                answer += 5
            else:
                answer += 10 - int(storey[i])
                storey[i] = '0'
                storey[i-1] = str(int(storey[i-1])+1)
    
    if int(storey[0]) == 10:
        return answer + 1
    elif int(storey[0]) > 5:
        return answer + (10 - int(storey[0])) + 1
    else:
        return answer+int(storey[0])

