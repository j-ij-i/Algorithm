function solution(n) {
    var answer = '';
    while(n > 0){
        a = parseInt(n / 3)
        b = n % 3
        if(b == 0){
            b = 4
            a -= 1
        }
        n = a
        answer = (b) + answer
    }
    return answer;
}