N = int(input())

for _ in range(N):
    n, target = list(map(int, input().split(" ")))
    result = 0
    qList = list(map(int, input().split(" ")))

    while True:
        # print(max(qList))
        if qList[0] == max(qList):
            qList.pop(0)
            result += 1
            if target == 0:
                break
            else:
                target = target - 1
        else:
            qList.append(qList.pop(0))
            if target == 0:
                target = len(qList)-1
            else:
                target = target - 1

    print(result)
