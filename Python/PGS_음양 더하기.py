def solution(absolutes, signs):
    result = 0
    for i in range(0,len(signs)):
        if not signs[i]:
            absolutes[i] *= -1
        result += absolutes[i]
        
    return result