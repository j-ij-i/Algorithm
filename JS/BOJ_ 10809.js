let input = require('fs').readFileSync('/dev/stdin').toString();
input = input.toString();
const arr = Array.from({ length: 26 }, (v, i) => String.fromCharCode(i + 97));

let sum = ('');
for(let i = 0 ; i < arr.length ; i++){
    let ishere = false;
    let none = -1;
    for(let j = 0 ; j < input.length ; j++){
        if(arr[i] === input[j]){
            sum += j + " ";
            ishere = true;
        }
    }
    if(!ishere){
        sum += none + " ";
    }
}
console.log(sum);