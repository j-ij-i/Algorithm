let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const a = Number(input[0]);
const b = Number(input[1]);

const c = b % 10;
const d = Math.floor((b % 100)/ 10);
const e = Math.floor(b / 100);

console.log(a * c);
console.log(a * d);
console.log(a * e);
console.log(a * b);