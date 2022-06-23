import sys
from collections import deque
def input():
    return sys.stdin.readline().rstrip()

queue = deque()
N = int(input())
for _ in range(N):
    cmdline = input().split()

    if cmdline[0] == 'push':
        queue.append(cmdline[1])
    elif cmdline[0] == 'pop':
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif cmdline[0] == 'empty':
        if len(queue) > 0:
            print(0)
        else:
            print(1)
    elif cmdline[0] == 'size':
        print(len(queue))
    elif cmdline[0] == 'front':
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif cmdline[0] == 'back':
        if queue:
            print(queue[-1])
        else:
            print(-1)