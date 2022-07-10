from collections import deque

m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[-1] * m for _ in range(n)]
dx, dy = (0, 0, -1, 1), (1, -1, 0, 0)

