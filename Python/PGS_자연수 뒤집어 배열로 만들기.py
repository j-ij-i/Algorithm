def solution(n):
    arr = str(n)
    answer = []
    for i in arr:
        answer.append(int(i))
    answer.reverse()
    return answer