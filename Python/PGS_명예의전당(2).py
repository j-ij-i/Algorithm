import heapq
def solution(k, score):
    answer = []
    q = []
    
    for i in score:
        if len(q) < k:
            heapq.heappush(q, i)
        else:
            heapq.heappush(q, i)
            heapq.heappop(q)
        temp = heapq.heappop(q)
        answer.append(temp)
        heapq.heappush(q,temp)
    
    return answer