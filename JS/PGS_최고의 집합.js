function solution(n, s) {
    let answer = [];
    
    const quo = Math.floor(s/n);
    const rem = Number(s%n);
    
    for(let i = 0; i < n ; i++){
        answer.push(quo);
    }
    for(let i = 0 ; i < rem ; i ++){
        answer[i] += 1;
    }
    answer.sort();
    
    if(answer[0] == 0){
        return [-1];
    }else{
        return answer;
    }
}