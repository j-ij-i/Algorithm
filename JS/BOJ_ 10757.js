let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let num = input.split(" ");
const sum = BigInt(num[0])+BigInt(num[1]);
const result = sum.toString().split("n").join("");
console.log(result);