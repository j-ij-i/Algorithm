let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let sum ='';

let num = Number(input[0]);
let distance = Number(input[1]);
let i = 0;
let arr = new Array;

for(let i = 1; i <=num ; i++){
    arr.push(i);
}

while(true){
    if(arr.length === 0){
        break;
    }else if(sum.length !== 0){
        sum += ", ";
    }
    
    i = i + distance - 1;
    if(arr.length < i ){
        i = arr.length - i
    }else {

   }

   slice()
}

console.log("<"+sum+">");