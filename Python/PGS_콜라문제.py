def solution(a, b, n):
    answer = 0
    while True:
        temp = n
        if temp < a:
            break
        else:
            if temp%a==0:
                temp = (temp//a)*b
                answer += temp
            else:
                t = temp%a
                temp = (((temp-t)//a)*b)
                answer += temp
                temp += t        
        n = temp                
            
        
    return answer