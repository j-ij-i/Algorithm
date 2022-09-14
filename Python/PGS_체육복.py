def solution(n, lost, reserve):
    answer = 0
    lost.sort()
    reserve.sort()
    set1 = set(lost)
    set2 = set(reserve)
    
    same_student = (set1 & set2)
    for i in same_student:
        lost.remove(i)
        reserve.remove(i)
    for i in reserve:
        for j in lost:
            if abs(i-j) == 1:
                lost.remove(j)
                break
        
    answer = n - len(lost)
    return answer