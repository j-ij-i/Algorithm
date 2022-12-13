def solution(want, number, discount):
    answer = 0
    target = 0
    total_cnt = sum(number)
    
    lists = dict()
    
    for i in range(len(number)):
        lists[want[i]] = number[i]
    copy_lists = lists.copy()
    
    while target < len(discount):
        for i in range(target, target+total_cnt):
            if i >= len(discount):
                target = len(discount)
                break
            elif discount[i] not in want:
                target = i + 1
                break
            elif discount[i] in want:
                if copy_lists[discount[i]] <= 0:
                    copy_lists = lists.copy()
                    target += 1
                    break
                else:
                    copy_lists[discount[i]] -= 1
                    print(copy_lists[discount[i]])
        else:
            answer += 1
            target += 1
        copy_lists = lists.copy()
                        
    return answer