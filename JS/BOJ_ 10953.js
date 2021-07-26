let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let num1 = input[0];

for(var i=1; i<=input[0]; i++){
    let num = input[i].split(" ");
    sum += `Case #${i}: ${Number(num[0])} + ${Number(num[1])} = ${Number(num[0])+Number(num[1])} \n`
}
console.log(sum);