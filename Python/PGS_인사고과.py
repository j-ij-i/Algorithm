def solution(scores):
    wh_score = scores[0]
    wh_score_sum = sum(scores[0])
    
    arr = []
    max_arr = []
    
    n = len(scores)
    cnt = 0    
    scores.sort(key=lambda x:x[0])
    
    for i in scores:
        max_arr.append(i[1])
    
    max_arr.sort(reverse=True)
    
    while cnt < n:
        temp = scores.pop(0)
        if max_arr[0] > temp[1]:
            if wh_score == temp:
                return -1
        elif max_arr[0] == temp[1]:
            max_arr.pop(0)
            arr.append(sum(temp))
        cnt += 1
    
    arr.sort(reverse=True)
    result = 1
    
    for i in arr:
        if wh_score_sum == i:
            return result
        else:
            result+=1
