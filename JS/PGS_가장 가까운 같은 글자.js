function solution(s) {
    var answer = [];
    
    const arr = Array.from({length: 26}, () => -1);
    
    
    for(let i = 0 ; i < s.length ; i ++){
        if(arr[(s[i].charCodeAt(0))-97] == -1){
            answer.push(-1)
            arr[(s[i].charCodeAt(0))-97] = 0
        }else{
            answer.push(arr[(s[i].charCodeAt(0))-97])
            arr[(s[i].charCodeAt(0))-97] = 0
        }
        for(let j = 0 ; j < 26 ; j ++){
            if(arr[j] > -1){
                arr[j] += 1
            }
        }
    }
    
    return answer;
}