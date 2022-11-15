import sys
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/testcase.txt', 'r')

k = int(input())
w,h = map(int, input().split())
arr = [[0 for _ in range(w)] for _ in range(h)]

dx = [0]

for i in range(h):
    temp = list(map(int,input().split()))
    for j in range(len(temp)):
        arr[i][j] = int(temp[j])

