from collections import defaultdict
from itertools import combinations

def solution(orders, course):
    answer = []
    for num in course:
        arr = defaultdict(int)
        for order in orders:
            orderlist = list(order)
            orderlist.sort()
            for p in list(combinations(orderlist,num)):
                orderstr = (''.join(p))
                arr[orderstr] += 1
        sorted_arr = sorted(arr.items(), key = lambda item: item[1], reverse =True)
        max_val = 0
        for i in sorted_arr:
            max_val = max(max_val, i[1])
            if max_val == i[1] and max_val >= 2:
                answer.append(i[0])
    answer.sort()
    return answer