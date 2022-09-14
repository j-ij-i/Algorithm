import sys
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/Python/testcase.txt', 'r')
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
m = int(input())
M = list(map(int, input().split()))

A.sort()

for i in M:
    left = 0
    right = n-1
    flag = False
    while left <= right:
        mid = (left + right) // 2
        if A[mid] == i:
            flag = True
            break
        elif A[mid] > i:
            right = mid - 1
        else:
            left = mid + 1

    if flag:
        print(1)
    else:
        print(0)