from collections import defaultdict 
def solution(nums):
    dic = defaultdict(int)
    max_num = len(nums)//2
    for i in nums:
        dic[i] += 1
    if max_num < len(dic):
        return max_num
    else:
        return len(dic)