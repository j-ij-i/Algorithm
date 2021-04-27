let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

for(let i = 1 ; i <= input[0] ; i++){
    let sum = ('');
    let str = input[i].split(" ");
    let strtext = str[1].split("");
    for( let j = 0 ; j < strtext.length ; j++){
        for(let y= 0 ; y< Number(str[0]) ; y++){
            sum +=`${strtext[j]}`;
        }
    }
    console.log(sum);
}