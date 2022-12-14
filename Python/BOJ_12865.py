import sys
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/testcase.txt', 'r')

n, k = map(int, input().split())

w = [0 for _ in range(n+1)]
v = [0 for _ in range(n+1)]
dp = [[0 for _ in range(k+1)]for _ in range(n+1)]

for i in range(1,n+1):
    w[i], v[i] = map(int, input().split())
    
for i in range(1,n+1):
    for j in range(1, k+1):
        if w[i] > j:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max( (dp[i-1][j-w[i]] + v[i]), dp[i-1][j])
            
print(dp[n][k])