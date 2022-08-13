result = [0] * 20000001

n = int(input())
arr1 = list(map(int, input().split()))
m = int(input())
arr2 = list(map(int, input().split()))

for i in arr1:
    if i >= 0:
        result[i] += 1
    else:
        na = abs(i)
        result[na+10000000] += 1

for i in arr2:
    if i >= 0:
        print(result[i], end=' ')
    else:
        na = abs(i)
        print(result[na+10000000], end=' ')