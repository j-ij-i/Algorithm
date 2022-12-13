function solution(want, number, discount) {
    let answer = 0;
    let target = 0;
    let total_cnt = number.reduce((a,b) => a+b, 0);
    
    const lists = {};
    
    for(let i = 0 ; i < number.length ; i++){
        lists[want[i]] = number[i];
    }
    
    let copy_lists = Object.assign({}, lists);
    
    while(target < discount.length){
        Flag = true
        for(let i = target ; i < target + total_cnt ; i++){
            if(i >= discount.length){
                target = discount.length;
                Flag = false
                break
            }else if(!(Object.keys(copy_lists).includes(discount[i]))){
                target = i + 1
                Flag = false
                break
            }else if(Object.keys(copy_lists).includes(discount[i])){
                if(copy_lists[discount[i]] <= 0){
                    copy_lists = Object.assign({},lists)
                    target += 1
                    Flag = false
                    break
                }else{
                    copy_lists[discount[i]] -= 1
                }
            }
        }
        if(Flag){
            answer += 1
            target += 1
        }
        copy_lists = Object.assign({},lists)
    }
    
    return answer;
}