import sys
input = sys.stdin.readline

sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/testcase.txt', 'r')

n, m = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))
b = list(map(int, sys.stdin.readline().split()))

c = a+b
c.sort()

print(*c)