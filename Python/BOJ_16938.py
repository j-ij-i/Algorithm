import sys
from itertools import combinations
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/testcase.txt', 'r')

n, l, r, x = map(int, input().split())

A = list(map(int, input().split()))
A.sort()

result = 0

for i in range(2, n+1):
    for comb in combinations(A, i):
        if l <= sum(comb) <= r:
            if max(comb) - min(comb) >= x:
                result += 1

print(result)
