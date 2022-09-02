def solution(queue1, queue2):
    answer = 0
    sum1 = sum(queue1)
    sum2 = sum(queue2)

    s1 = 0
    s2 = 0

    while True:
        if answer > 600000:
            answer = -1
            break
        if sum1 == sum2:
            break
        else:
            if sum1 > sum2:
                if len(queue1) == 1:
                    answer = -1
                    break
                else:
                    answer += 1
                    sum1 -= queue1[s1]
                    sum2 += queue1[s1]
                    queue2.append(queue1[s1])
                    s1 += 1
            else:
                if len(queue2) == 1:
                    answer = -1
                    break
                else:
                    answer += 1
                    sum2 -= queue2[s2]
                    sum1 += queue2[s2]
                    queue1.append(queue2[s2])
                    s2 += 1

    return answer