
import sys
from collections import deque
def input():
    return sys.stdin.readline().rstrip()

N = int(input())

q = deque([i+1 for i in range(N)])

while len(q) > 2:
    q.popleft()
    n = q.popleft()
    q.append(n)

print(q.pop())