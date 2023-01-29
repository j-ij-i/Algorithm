def solution(id_pw, db):
    answer = ''
    dic = dict()
    for d in db:
        dic[d[0]] = d[1]
    
    if id_pw[0] not in dic:
        return 'fail'
    elif dic[id_pw[0]] == id_pw[1]:
        return 'login'
    else:
        return 'wrong pw'
    return answer