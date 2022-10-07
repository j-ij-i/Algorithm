from collections import deque
def solution(n, computers):
    answer = 0
    arr = []
    for i in computers:
        arr.append([i,False])
    # print(arr)
    
    q = deque()
    
    for i in range(len(arr)):
        if arr[i][1] == True:
            continue
        else:
            answer += 1
            arr[i][1] = True
            q.append(arr[i])
            while q:
                qarr, flag = q.popleft()
                for j in range(len(qarr)):
                    if qarr[j] == 1 and arr[j][1] == False:
                        arr[j][1] = True
                        q.append(arr[j])    
    
    return answer