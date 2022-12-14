def solution(m, n, puddles):
    answer = 0
    arr = [[0 for _ in range(m+1)] for _ in range(n+1)]

    for p in puddles:
        x,y = p
        arr[y][x] = -1
    
    arr[1][1] = 1
    
    for i in range(1,n+1):
        for j in range(1,m+1):
            if arr[i][j] == -1:
                continue
            if arr[i-1][j] == -1 and arr[i][j-1] == -1:
                continue
            elif arr[i][j-1] == -1:
                arr[i][j] += arr[i-1][j]
            elif arr[i-1][j] == -1:
                arr[i][j] += arr[i][j-1]
            else:
                arr[i][j] += (arr[i][j-1] + arr[i-1][j])
                
    return arr[n][m] % 1000000007