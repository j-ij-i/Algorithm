def solution(s):
    answer = ''
    arr = list(s)
    arr.sort(reverse=True)
    return(''.join(arr))