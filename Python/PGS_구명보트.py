from collections import deque
def solution(people, limit):
    answer = 0
    deq = deque(sorted(people))
    while deq:
        if len(deq) == 1:
            answer += 1
            break
        else:
            if deq[0]+deq[-1] > limit:
                deq.pop()
                answer += 1
            else:
                deq.popleft()
                deq.pop()
                answer += 1
            
    return answer


from collections import deque
def solution(people, limit):
    
    answer = 0
    arr = deque(sorted(people))
    
    while arr:
        temp = arr.pop()
        if arr and arr[0] + temp > limit:
            answer += 1
        elif not arr:
            answer += 1
        else:
            arr.popleft()
            answer += 1
        

    return answer