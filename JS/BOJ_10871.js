//정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let sum = ('');
let num1 = input[0].split(" ");
let num2 = input[1].split(" ");

const N = Number(num1[0]);
const X = Number(num1[1]);

for(let i = 0 ; i<N ; i++){
    if(X > num2[i]){
        sum += Number(num2[i])+" ";
    }   
}
console.log(sum);