import heapq

def getMaxCop(problems):
    problems.sort(key=lambda x:x[1])
    return problems[-1][1]

def getMaxAlp(problems):
    problems.sort()
    return problems[-1][0]

def solution(alp, cop, problems):
    problems.append([0, 0, 0, 1, 1])
    problems.append([0, 0, 1, 0, 1])
    maxAlp = getMaxAlp(problems)
    maxCop = getMaxCop(problems)

    INF = float('inf')
    hp = [(0, alp, cop)]
    distance = [INF] *(22651)
    distance[alp * 150 + cop] = 0
    answer = -1
    while hp:
        curNode = heapq.heappop(hp)
        dist, curAlp, curCop = curNode
        if distance[curAlp * 150 + curCop] < dist:
            continue
        if curAlp >= maxAlp and curCop >= maxCop:
            answer = dist
            break
        # 간선
        for alpReq, copReq, alpRwd, copRwd, cost in problems:
            if not (curAlp >= alpReq and curCop >= copReq):
                continue
            nextAlp = min(maxAlp, curAlp + alpRwd)
            nextCop = min(maxCop, curCop + copRwd)
            nextCost = cost + dist
            if distance[nextAlp * 150 + nextCop] > nextCost:
                distance[nextAlp * 150 + nextCop] = nextCost
                heapq.heappush(hp, (nextCost, nextAlp, nextCop))

    return answer