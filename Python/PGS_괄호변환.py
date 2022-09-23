def funcChange(w):
    result = ''
    targetlen = len(w)
    if len(w)<= 0:
        return result

    while len(result) < targetlen:
        startnum = 0
        endnum = 0
        for i in range(len(w)):
            if w[i] == '(':
                startnum += 1
            elif w[i] == ')':
                endnum += 1
            if startnum == endnum:
                break
        u = w[0:i+1]
        v = w[i+1:len(w)]
        w = v
        
        stack = []
        for i in u:
            if i == '(':
                stack.append('(')
            else:
                if len(stack) <= 0:
                    break
                else:
                    stack.pop()
        else:
            result += u
            w = v
            continue
        result += '('
        result += funcChange(v)
        result += ')'
        u = u[1:len(u)-1]
        for i in u:
            if i == '(':
                result += ')'
            else:
                result += '('
    print(result)
    return result
    
    
def solution(p):
    answer = ''
    answer += funcChange(p)
    return answer