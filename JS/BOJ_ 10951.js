//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.\
let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

for(let i = 0; i<input.length - 1; i++){
    let num = input[i].split(" ");
    console.log(Number(num[0])+Number(num[1]));
}