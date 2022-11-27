from collections import defaultdict
def solution(topping):
    answer = 0
    ldic = defaultdict(int)
    rdic = defaultdict(int)
    target = len(topping)//2
    
    # 아래로 내려가는
    # left
    for i in range(0,target):
        ldic[topping[i]] += 1
        
    # right 
    for i in range(target, len(topping)):
        rdic[topping[i]] += 1
    
    if len(ldic) == len(rdic):
        answer += 1
        #print('aa')
    
    for t in range(target-1,0,-1):
        rdic[topping[t]] += 1
        ldic[topping[t]] -= 1
        if ldic[topping[t]] <= 0:
            del ldic[topping[t]]
        if len(ldic) < len(rdic):
            break
        elif len(ldic) == len(rdic):
            answer += 1
            #print('t',t)
    
    # 위로 올라가는
    ldic = defaultdict(int)
    rdic = defaultdict(int)

    # left
    for i in range(0,target):
        ldic[topping[i]] += 1

    # right
    for i in range(target, len(topping)):
        rdic[topping[i]] += 1

    for t in range(target,len(topping)):
        rdic[topping[t]] -= 1
        ldic[topping[t]] += 1
        if rdic[topping[t]] <= 0:
            del rdic[topping[t]]
        if len(ldic) > len(rdic):
            break
        elif len(ldic) == len(rdic):
            answer += 1
            #print('z',t)
            

    return answer