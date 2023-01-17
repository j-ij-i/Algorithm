def solution(quiz):
    answer = []
    for q in quiz:
        e,a = q.split('=')
        if eval(e) == int(a):
            answer.append('O')
        else:
            answer.append('X')

    return answer