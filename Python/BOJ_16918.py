import sys
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/testcase.txt', 'r')

r,c,n = map(int, input().split())
dx = [0,0,-1,1]
dy = [1,-1,0,0]
arr = [ [0 for _ in range(r)] for _ in range(c)]
bomb = [[False for _ in range(r)] for _ in range(c)]
for i in range(r):
    temp = input()
    for j in range(c):
        arr[j][i] = temp[j]

sec = 1
while sec <= n:
    if sec%2 == 0:  
        for i in range(r):
            for j in range(c):
                if arr[j][i] == 'O':
                    bomb[j][i] = True
                    for d in range(4):
                        nx = dx[d]+i
                        ny = dy[d]+j
                        if 0<=nx<r and 0<=ny<c:
                            bomb[ny][nx] = True
        for i in range(r):
            for j in range(c):
                arr[j][i] = 'O'
    else:
        for i in range(r):
            for j in range(c):
                if bomb[j][i] == True:
                    arr[j][i]='.'
                    bomb[j][i] = False
    sec += 1
for i in range(r):
    for j in range(c):
        print(arr[j][i], end='')
    print()