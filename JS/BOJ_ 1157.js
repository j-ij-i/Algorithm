let input = require('fs').readFileSync('/dev/stdin').toString();

let arr = input.trim().split(' ');
let num = 0;
for(let i = 0 ; i < arr.length ; i++){
    if(arr[i] !== ''){
        num++;
    }
}
console.log(num);