let input = require('fs').readFileSync('/dev/stdin').toString();
input = Number(input);

let num5 = Math.floor(input/5);
let num3 = 0;
let curNum = 0;
let isPoss = false;
for(let i = num5 ; i>=0 ; i--){
    curNum = input;
    curNum -= (i*5);
    if(!(curNum%3)){
        num5 = i;
        num3 = Math.floor(curNum/3);
        isPoss = true;
       break;
    }
}
if(!(isPoss)){
    console.log("-1");
}else
    console.log(num5+num3);