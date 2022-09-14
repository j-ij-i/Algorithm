def solution(n, times):
    answer = 0
    left = min(times)
    right = n * max(times)
    while left <= right:
        mid = (left + right) // 2
        checked = 0
        for i in times:
            checked += mid // i
            if checked >= n:
                break
        if checked >= n:
            answer = mid
            right = mid-1
        else:
            left = mid+1        
    return answer