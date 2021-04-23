let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let num = Number(input[0]) * Number(input[1]) * Number(input[2]);

let str2= (`${num}`);
let str = new Array(10);

for(let i = 0 ; i < 10 ; i++){
    str[i] = 0;
}

for(let i = 0 ; i < str2.length; i++){
    let num2 = Number(str2[i]);
    str[num2] += 1;
}

for(let i = 0 ; i < 10 ; i++){
    console.log(str[i]);
}
