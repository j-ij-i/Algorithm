let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let order = 0;
let max = 0;

for(let i = 0; i < 9 ; i++){
    let num = input[i];
    if(Number(num)>max){
        max = Number(num);
        order = i+1;
    }
}

console.log(max);
console.log(order);