let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

const T = Number(input[0]);
let sum ='';
for(var i = 1; i<=T ; i++){
    let num = input[i].split(" ");
    sum+=Number(num[0])+Number(num[1])+"\n";
}
console.log(sum);