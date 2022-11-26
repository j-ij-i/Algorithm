from collections import defaultdict
def solution(topping):
    answer = 0
    ldic = defaultdict(int)
    rdic = defaultdict(int)
    target = len(topping)//2
    
    # 아래로 내려가는
    # left
    for i in range(0,target):
        ldic[i] += 1
        
    # right 
    for i in range(target, len(topping)):
        rdic[i] += 1
    
    if len(ldic) == len(rdic):
        answer += 1
        for t in range(target,0,-1):
            rdic[t] += 1
            ldic[t] -= 1
            if ldic[t] == 0:
                del rdic[t]
            if not len(ldic) == len(rdic):
                break
            else:
                answer += 1
    
    ldic = defaultdict(int)
    rdic = defaultdict(int)
    
    # 위로 올라가는
    # left
    for i in range(0,target):
        ldic[i] += 1
        
    # right 
    for i in range(target, len(topping)):
        rdic[i] += 1  
    
    for t in range(target,len(topping)-1):
        rdic[t] -= 1
        ldic[t] += 1
        if rdic[t] == 0:
            del rdic[t]
        if not len(ldic) == len(rdic):
            break
        else:
            answer += 1
    
    return answer