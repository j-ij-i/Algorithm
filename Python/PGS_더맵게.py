import heapq
def solution(scoville, K):
    answer = 0
    heap = []
    for i in scoville:
        heapq.heappush(heap, i)
    while heap[0] < K and len(heap)>=2:
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        c = a + (b*2)
        heapq.heappush(heap, c)
        answer+= 1
    if heap[0] < K:
        return -1
    return answer