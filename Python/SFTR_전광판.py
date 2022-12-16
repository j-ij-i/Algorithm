
arr = [[1,1,1,0,1,1,1],[0,0,1,0,0,1,0],[1,0,1,1,1,0,1],[1,0,1,1,0,1,1],[0,1,1,1,0,1,0],[1,1,0,1,0,1,1],[1,1,0,1,1,1,1],[1,1,1,0,0,1,0],[1,1,1,1,1,1,1],[1,1,1,1,0,1,1]]

n = int(input())

for _ in range(n):
    init, change = input().split()    

    while len(init)<5:
        init = '-'+init
    while len(change)<5:
        change = '-'+change
    result = 0
    for i in range(5):
        if init[i] == '-' and change[i] == '-':
            continue
        elif init[i] == '-':
            for a in arr[int(change[i])]:
                if a == 1:
                    result += 1
        elif change[i] == '-':
            for a in arr[int(init[i])]:
                if a == 1:
                    result += 1
        else:
            for a in range(7):
                if not arr[int(init[i])][a] == arr[int(change[i])][a]:
                    result += 1
    print(result)