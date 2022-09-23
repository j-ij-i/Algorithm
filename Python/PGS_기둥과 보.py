def impossible(result):
    GI, BO = 0, 1
    for x, y, a in result:
        if a == GI:
            if y != 0 and (x,y,BO) not in result and (x-1,y,BO) not in result and (x,y-1,GI) not in result:
                return True
        elif a == BO:
            if (x+1,y-1,GI) not in result and (x,y-1,GI) not in result and not((x+1,y,BO) in result and (x-1,y,BO) in result):
                return True
                
    return False
    
def solution(n, build_frame):
    result = set()
    for x, y, a, build in build_frame:
        item = (x, y, a)
        if build: # 추가일 때
            result.add(item)
            if impossible(result):
                result.remove(item)
        elif item in result: # 삭제할 때
            result.remove(item)
            if impossible(result):
                result.add(item)
    answer = list(map(list, result))
    return sorted(answer, key = lambda x : (x[0], x[1], x[2]))