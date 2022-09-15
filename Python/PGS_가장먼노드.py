import heapq
def solution(n, edge):
    
    INF = float('inf')
    graph = [[] for _ in range(n+1)]

    for s, e in edge:
        graph[s].append([e,1])
        graph[e].append([s,1])
    
    def dikjstra(start):
        distance = [INF] * (n+1)
        heap = []
        distance[start] = 0
        heapq.heappush(heap, [start, 0])
        
        while heap:
            index, dist = heapq.heappop(heap)
            if dist > distance[index]:
                continue
            for node_index, node_cost in graph[index]:
                cost = node_cost + dist
                if cost < distance[node_index]:
                    distance[node_index] = cost
                    heapq.heappush(heap, [node_index,cost])
        return distance
    
    
    result = dikjstra(1)
    max_val = 0
    answer = 1
    result[0] = 0
    
    for j in result:
        if max_val < j:
            max_val = j
            answer = 1
        elif max_val == j:
            answer += 1

    return answer