let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let isContinu = false;
let sum = 0;
for(let i = 1 ; i<=input[0]; i++){
    sum = 0;
    let num = input[i].split("");
    let point = 1;
    for(let j = 0; j< num.length ; j++){
        if(isContinu===false && num[j] === "O"){
            sum = sum + point;
            isContinu = true;
            point++;
        }else if(isContinu===true && num[j]==="O"){
            sum = sum + point;
            point++;
        }else if(num[j]==="X"){
            point = 1;
            isContinu = false;
        }
    }
    console.log(sum);
}