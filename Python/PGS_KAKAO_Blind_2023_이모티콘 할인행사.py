import itertools
def solution(users, emoticons):
    answer = []
    sale = [10,20,30,40]
    sale_list = (list(itertools.product(sale, repeat=len(emoticons))))
    max_result = [0,0]
    for sale_per in sale_list:
        signnum = 0
        money = 0
        for user in users:
            buy_per, max_money= user
            all_money = 0
            flag = False
            for i in range(len(emoticons)):                
                if int(buy_per) <= int(sale_per[i]):
                    all_money += int(emoticons[i] - emoticons[i]*(0.01 * sale_per[i]))
                if all_money >= max_money:
                    flag = True
                    break
            if flag:
                signnum += 1
            else:
                money += all_money
        if max_result[0] < signnum:
            max_result = [signnum, money]
        elif max_result[0] == signnum:
            if max_result[1] <money:
                max_result = [signnum, money]

    return max_result