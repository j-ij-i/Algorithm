import sys
N, M = map(int, input().split())
s = set()

for _ in range(N):
    sinput = sys.stdin.readlined()
    s.add(sinput)
result = 0
for _ in range(M):
    check = sys.stdin.readlined()
    if check in s:
        result+=1
print(result)