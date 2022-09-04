from collections import deque

N, M = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input())))

def bfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    result = 0
    queue = deque()
    queue.append((x, y, 1))

    while queue:
        x, y, cnt = queue.popleft()

        if x == N-1 and y == M-1:
            result = cnt
            return result
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny, cnt+1))


print(bfs(0, 0))