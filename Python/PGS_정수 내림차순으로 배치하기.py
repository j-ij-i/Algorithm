def solution(n):
    answer = 0
    n = str(n)
    arr = []
    for i in n:
        arr.append(i)
    arr.sort(reverse=True)
    return int(''.join(arr))