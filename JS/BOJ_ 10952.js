//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let i = 0;
let sum = ('');
while(input[i] !== "0 0"){
    let num = input[i].split(" ");
    sum += Number(num[0])+Number(num[1])+"\n";
    i++;
}
console.log(sum);