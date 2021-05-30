let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let input = "2\nI am happy today\nWe want to win the first prize";
input = input.split('\n');
let sum = '';
for(let i = 1 ; i <=input[0] ; i++){
    reverse(input[i]);
}

function reverse(i){
    let element = i.split(' ');
    for(let i = 0; i<length.element ; i++){
        const step1 = element[i].split('');
        const step2 = step1.reverse();
        const step3 = step2.join('');
        console.log(step3+" ");
    }
}  