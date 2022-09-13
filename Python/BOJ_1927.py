import heapq
import sys
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/Python/testcase.txt', 'r')

input = sys.stdin.readline
n = int(input())

heap = []
for _ in range(n):
    x = int(input())
    if x == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, x)