from collections import deque

def solution(numbers, target):
    answer = 0
    result = 0
    q = deque()
    q.append((result, numbers))
    while q:
        res, numlist = q.popleft()
        if len(numlist) == 0:
            if res == target:
                answer+=1
        else:
            copy_list = numlist.copy()
            nums = copy_list.pop()
            q.append((res+nums, copy_list))
            q.append((res-nums, copy_list))
            
    return answer