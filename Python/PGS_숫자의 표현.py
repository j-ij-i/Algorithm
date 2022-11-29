from collections import deque
def solution(n):
    answer = 0
    q = deque()
    qsum = 0
    for i in range(1,n+1):
        q.append(i)
        qsum += i
        
        if qsum < n:
            continue
        elif qsum == n:
            answer += 1
        else:
            while qsum > n:
                temp = q.popleft()
                qsum -= temp
            if qsum == n:
                answer += 1
    
    return answer