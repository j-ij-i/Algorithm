def solution(numbers):
    answer = -1
    arr = [1,2,3,4,5,6,7,8,9]
    set1 = set(arr)
    set2 = set(numbers)
    answer = sum(set1-set2)

    return answer