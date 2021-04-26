let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');


let num = input[1].toString();
let sum = 0;

for(let i = 0 ; i< input[0]; i++){
    sum = sum + Number(num[i]);
}

console.log(sum);