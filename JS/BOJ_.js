//n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.

let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let sum = 0;
for(var i = 1; i <= input[0] ; i++){
     sum = sum+i;
}
console.log(sum);