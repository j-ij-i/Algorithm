function solution(food) {
    var answer = '';
    
    for(let i = 1 ; i < food.length; i++){
        for(let j = 0 ; j < parseInt(food[i]/2); j++){
            answer += String(i)
        }
    }
    const temp = answer.split('').reverse().join('');
    
    answer += '0'
    answer += temp
    
    
    return answer;
}