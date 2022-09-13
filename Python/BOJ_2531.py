import sys
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/Python/testcase.txt', 'r')


n, d, k, c = map(int, sys.stdin.readline().rsplit())
arr = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
max_val = 0
data = dict()
for i in range(n):
    if i == 0:
        data[c]=1
        for j in range(k):
            if arr[j+i] not in data:
                data[int(arr[j+i])] = 1
            else:
                data[int(arr[j+i])] += 1
    elif i > n-k:
        if data[arr[i-1]] <= 1:
            del(data[arr[i-1]])
        else:
            data[arr[i-1]] -= 1
        
        if arr[i-(n-k)-1] not in data:
            data[int(arr[i-(n-k)-1])] = 1
        else:
            data[int(arr[i-(n-k)-1])] += 1

    else:
        if data[arr[i-1]] <= 1:
            del(data[arr[i-1]])
        else:
            data[arr[i-1]] -= 1

        if arr[i+k-1] not in data:
            data[int(arr[i+k-1])] = 1
        else:
            data[int(arr[i+k-1])] += 1
    print(data)
    max_val = max(max_val, len(data.keys()))
        
print(max_val)