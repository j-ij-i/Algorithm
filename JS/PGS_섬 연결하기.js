function solution(n, costs) {
    var answer = 0;
    costs.sort((a,b) => (a[2]-b[2]))
    let link = new Set([costs[0][0]]);

    while(link.size < n){
        for(let v = 0 ; v < costs.length; v++){        
            if(link.has(costs[v][0]) && link.has(costs[v][1])){
                continue;
            }
            if(link.has(costs[v][0]) || link.has(costs[v][1])){
                answer += costs[v][2]
                link.add(costs[v][0])
                link.add(costs[v][1])    
                break
            }
        }
    }
    return answer;
}