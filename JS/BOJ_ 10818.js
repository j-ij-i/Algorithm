let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let max = -1000001;
let min = 1000001;

let num = input[1].split(" ");
for(let i = 0; i<input[0]; i++){
    if(min > Number(num[i]))
        min = Number(num[i]);
    if(max < Number(num[i])){
        max = Number(num[i]);
    }
}
console.log(min+" "+max);