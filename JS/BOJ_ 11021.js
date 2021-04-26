let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let sum = ('');

for(i=1; i<=input[0]; i++){
    let num = input[i].split(" ");
    sum += `Case #${i}: ${Number(num[0])+Number(num[1])} \n`
}
console.log(sum);