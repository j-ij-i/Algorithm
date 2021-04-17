let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split(' ');

let num1 = parseInt(input[0]);
let num2 = parseInt(input[1]);

if(num2 < 45){
    if(num1>0){
    num1 -= 1;
    num2 = (num2+15);
    }else if(num1==0){
        num1 = 23;
        num2 = (num2+60)-45;
    }
}else if(num2 >= 45){
    num2 = num2 - 45;
}

console.log(num1, num2);