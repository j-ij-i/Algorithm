from re import L
import sys
import heapq
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/Python/testcase.txt', 'r')

input = sys.stdin.readline
v,e,x = tuple(map(int, input().split()))
INF = int(1e9)
graph = [[] for _ in range(v+1)]
#print(graph)
#print(INF)
for _ in range(e):
    a,b,cost = tuple(map(int, input().split()))
    graph[a].append((b,cost))
#print(graph)

def dijkstra(start):
    q = []
    distance = [INF]*(v+1)
    heapq.heappush(q,(0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        
        if distance[now] < dist:
            continue

        for node_index, node_cost in graph[now]:
            cost = dist + node_cost
            if distance[node_index] > cost:
                distance[node_index] = cost
            heapq.heappush(q,(cost, node_index))
    return distance

result = 0 
for i in range(1, v+1):
    go = dijkstra(i)
    back = dijkstra(x)
    result = max(result, go[x]+back[i])

print(result)