import sys
import heapq
input = sys.stdin.readline
INF = sys.maxsize

n = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(n+1)]
costs = [0]
for _ in range(n): costs.append(sys.stdin.readline().rstrip())

for i in range(1, n+1):
    for j in range(i+1, n+1):
        cost = 0
        for c1, c2 in zip(costs[i], costs[j]):
            cost += (int(c1)-int(c2))**2
        graph[i].append([j, cost])
        graph[j].append([i, cost])
s, e = tuple(map(int, input().split()))

#print(graph)
def dijkstra(start):
    heap = []
    distance = [INF for _ in range(n+1)]
    #print(distance)
    heapq.heappush(heap,[0,start])
    distance[start] = 0
    while heap:
        dist, index = heapq.heappop(heap)
        if distance[index] < dist:
            continue
        for node_index,node_cost in graph[index]:
            cost = node_cost+dist
            if distance[node_index] > cost:
                distance[node_index] = cost
                heapq.heappush(heap,[cost, node_index])
    return distance

result = dijkstra(s)
#print(result)
print(result[e])