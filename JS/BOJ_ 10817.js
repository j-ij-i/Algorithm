let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

const num = input.split(' ').map(v => Number(v));
num.sort((a,b) => a-b);
console.log(num[1]);