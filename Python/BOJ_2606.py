n = int(input())
pair = int(input())
graph = [[]*n for _ in range(n+1)]
for i in pair:
     comnum1, comnum2 = map(int, input().split())
     graph[comnum1].append(comnum2)
     graph[comnum2].append(comnum1)

cnt = 0
visited = [0]*(n+1)

def dfs(start):
     global cnt
     visited[start] = 1
     for i in graph[start]:
          if visited[i] == 0:
               dfs(i)
               cnt += 1


dfs(1)
print(cnt)