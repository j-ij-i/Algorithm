from collections import deque
def solution(maps):
    answer = 0
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]
    N,M = len(maps), len(maps[0])
    q = deque()
    q.append((0,0))
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0<=nx<N and 0<=ny<M and maps[nx][ny] == 1:
                    maps[nx][ny] = maps[x][y] + 1
                    q.append((nx,ny))
        
    if maps[N-1][M-1] == 1:
        return -1
    else:
        return maps[N-1][M-1]