let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let sum=0;
let num = input[1].split(" ");
let max = 0;
for(let i = 0 ; i < num.length ; i++){
    if(max < Number(num[i])){
        max = Number(num[i]);
    }
}
for(let i = 0 ; i < num.length ; i++){
    sum += Number(num[i])/max*100
}

console.log(sum/num.length);