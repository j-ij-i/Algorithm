from collections import deque
def solution(tickets):
    answer = []
    q = deque()
    q.append(("ICN"))
    
    while q:
        str = q.popleft()
        answer.append(str)
        if not tickets:
            break
        else:
            res = -1
            for i in range(len(tickets)):
                if tickets[i][0] == str:
                    for arr in tickets:
                        if arr[0] == tickets[i][1]:
                            break
                        elif len(tickets) == 1:
                            break
                    else:
                        continue
                        
                    if res < 0:
                        res = i
                    else:
                        if tickets[res][1] > tickets[i][1]:
                            res = i
            q.append((tickets[res][1]))
            tickets.pop(res)
                        
    return answer