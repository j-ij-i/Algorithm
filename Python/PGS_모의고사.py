def solution(answers):
    answer = []
    answer_num = len(answers)
    cnt_list = []
    
    # 1수포자
    cnt1 = 0
    arr1 = [5,1,2,3,4]
    
    # 2수포자
    cnt2 = 0
    arr2 = [5,2,1,2,3,2,4,2]    
    
    # 3수포자
    cnt3 = 0
    arr3 = [5,3,3,1,1,2,2,4,4,5]    
    
    for i in range(1, answer_num+1):
        temp1 = arr1[i%5]
        if temp1 == answers[i-1]:
            cnt1 += 1
            
        temp2 = arr2[i%8]
        if temp2 == answers[i-1]:
            cnt2+=1
            
        temp3 = arr3[i%10]
        if temp3 == answers[i-1]:
            cnt3+=1
    
    cnt_list.extend([cnt1,cnt2,cnt3])
    
    result = max(max(cnt1,cnt2),cnt3)

    for i in range(0,3):
        if cnt_list[i] == result:
            answer.append(i+1)
            
    return answer