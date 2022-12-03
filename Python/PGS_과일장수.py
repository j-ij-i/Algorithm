from collections import deque
def solution(k, m, score):
    answer = 0
    cnt = len(score)
    score = deque(sorted(score))
    trash = cnt % m
    while trash > 0:
        score.popleft()
        trash -= 1
    
    while score:
        arr = []
        for i in range(m):
            arr.append(score.popleft())
        answer += arr[0]*m
        arr = []
    return answer