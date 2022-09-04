from collections import deque

N, M = map(int, input().split())
graph = []
for _ in range(M):
    graph.append(list(map(int, input().split())))

# 다 1 이상이고 0이 없는 경우
flag = False

tomato_q = deque()
MAX_CNT = 1
dx = [0,0,-1,1]
dy = [1,-1,0,0]
for i in range(N):
    for j in range(M):
        if 1 == graph[j][i]:
            tomato_q.append((j, i, 1))
        elif graph[j][i] == 0:
            flag = True

if not flag:
    print(0)
else:
    while tomato_q:
        x, y, cnt = tomato_q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < M and 0 <= ny < N:
                if graph[nx][ny] == 0:
                    graph[nx][ny] = cnt+1
                    MAX_CNT = max(MAX_CNT, cnt+1)
                    tomato_q.append((nx,ny,cnt+1))
    #0이 있는 경우
    for grp in graph:
        if 0 in grp:
            print(-1)
            break
    else:
        if MAX_CNT == 1:
            print(0)
        else:
            print(MAX_CNT-1)