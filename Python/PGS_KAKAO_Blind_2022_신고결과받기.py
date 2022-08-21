def solution(id_list, report, k):
    reportList =[[] for row in range(len(id_list))]
    reportResult = [0 for row in range(len(id_list))]
    reportCount = [0 for row in range(len(id_list))]
    for i in report:
        reportTo, reportFrom = i.split(' ')
        idx = id_list.index(reportTo)
        if reportFrom in reportList[idx]:
            continue
        else:
            reportList[idx].append(reportFrom)
            reportResult[id_list.index(reportFrom)] += 1
    
    # 똑같이 신고할경우를 못잡음!!
    for i in range(len(reportList)):
        for j in range(len(reportList[i])):
            if reportResult[id_list.index(reportList[i][j])] >= k:
                reportCount[i] += 1     

    return reportCount