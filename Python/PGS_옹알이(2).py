def solution(babbling):
    answer = 0
    oor = ["aya","ye","woo","ma"]
    for item in babbling:
        temp_item = item
        
        for j in oor:
            temp_item = temp_item.replace(j+j, "")
        final_item = '1'*len(temp_item)
        if temp_item == item:
            while True:
                init_item = temp_item
                for j in oor:
                    change = '1'*len(j)
                    temp_item = temp_item.replace(j, change)
                if init_item == temp_item:
                    break
            if temp_item == final_item:
                answer += 1
    return answer