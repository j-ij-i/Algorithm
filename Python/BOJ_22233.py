import sys
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/Python/testcase.txt', 'r')

n, m = map(int, sys.stdin.readline().split())

data = dict()
for _ in range(n):
    data[sys.stdin.readline().rstrip()] = 1

cnt = n
for _ in range(m):
    keyword = sorted(sys.stdin.readline().rstrip().split(','))
    for kw in keyword:
        if kw in data.keys():
            if data[kw] >= 1:
                data[kw] -= 1
                cnt -= 1
    print(cnt)