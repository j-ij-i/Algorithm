def solution(today, terms, privacies):
    answer = []
    arr = dict()
    today_year, today_month, today_day = today.split('.')
    for term in terms:
        alp, time = term.split()
        arr[alp] = time
    
    for i in range(len(privacies)):
        flag = True
        date, term_type = privacies[i].split()
        year, month, day = date.split('.')
        year = int(year)
        day = int(day)
        tem_month = int(month)+int(arr[term_type])
        
        while tem_month > 12:
            if tem_month > 12:
                tem_month -= 12
                year += 1
        
        if day == 1:
            day = 28
            tem_month -= 1
            if tem_month < 1:
                tem_month = 12
                year -= 1
        else:
            day -= 1

        if int(today_year) > int(year):
            flag = False
        elif int(today_year) == int(year):
            if int(today_month) > int(tem_month):
                flag = False
            elif int(today_month) == int(tem_month):
                if int(today_day) > int(day):
                    flag = False

        
        if not flag:
            answer.append(i+1)


    return answer