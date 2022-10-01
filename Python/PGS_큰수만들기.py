from collections import deque
def solution(number, k):
    arr = deque(number)
    res = [arr.popleft()]
    while arr:
        x = arr.popleft()
        while res and res[-1] < x and k>0:
            res.pop()
            k -= 1
        res.append(x)
        
    while k > 0:
        res.pop()
        k-=1
    return ''.join(res)