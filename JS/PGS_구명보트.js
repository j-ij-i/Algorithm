function solution(people, limit) {
    var answer = 0;
    people.sort((a,b) => (a-b))
    while(people.length){
        let temp = people.pop()
        if ((people.length > 0) && (temp + people[0] > limit)){
            answer ++
        }else if(!people){
            answer ++
        }else{
            people.shift()
            answer ++
        }
    }
    return answer;
}