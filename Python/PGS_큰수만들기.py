from itertools import combinations
def solution(number, k):
    answer = ''
    arr = list(number)
    k = len(arr)-k
    perlist = combinations(arr,k)
    max = 0
    for i in perlist:
        num = int(''.join(i))
        if num > max:
            max = num
    print(max)
    return str(max)