from collections import deque

N = int(input())

list = deque(enumerate(map(int, input().split())))
result = []
while list:
    idx, balloonnum = list.popleft()
    result.append(idx+1)
    if balloonnum > 0:
        list.rotate(-(balloonnum-1))
    else:
        list.rotate(-balloonnum)

print(' '.join(map(str, result)))