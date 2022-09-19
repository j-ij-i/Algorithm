from collections import defaultdict

def solution(n, results):
    answer = 0
    win_graph = defaultdict(set)
    lose_graph = defaultdict(set)
    
    for winner, loser in results:
        win_graph[loser].add(winner)
        lose_graph[winner].add(loser)
        
    for i in range(1, n+1):
        for w in win_graph[i]:
            lose_graph[w].update(lose_graph[i])
        for l in lose_graph[i]:
            win_graph[l].update(win_graph[i])
    
    for i in range(1, n+1):
        if len(win_graph[i])+len(lose_graph[i]) == n-1:
            answer += 1            
    return answer