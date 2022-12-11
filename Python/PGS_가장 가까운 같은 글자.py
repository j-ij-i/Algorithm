def solution(s):
    answer = []
    
    arr = [-1 for i in range(26)]
    
    for i in s:
        if arr[ord(i)-97] == -1:
            answer.append(-1)
            arr[ord(i)-97] = 0
        else:
            answer.append(arr[ord(i)-97])
            arr[ord(i)-97] = 0
            
        for a in range(len(arr)):
            if arr[a] >= 0:
                arr[a] += 1
    
    return answer