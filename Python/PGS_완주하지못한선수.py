def solution(participant, completion):
    answer = ''
    data = dict()
    for i in participant:
        if i in data:
            data[i] += 1
        else:
            data[i] = 1
    for a in completion:
        data[a] -= 1
    
    for j in data:
        if data[j] == 1:
            return j