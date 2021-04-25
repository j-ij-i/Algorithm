//두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오.

let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let num = input[0].split(" ");

console.log(Number(num[0])-Number(num[1]));