function solution(n) {
    var answer = 0;
    const sq = Math.floor(Math.sqrt(n));
    if(sq*sq === n){
        return (sq+1)*(sq+1);
    }else
        return -1;
}