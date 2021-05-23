let input = require('fs').readFileSync('/dev/stdin').toString().split('/');

const K = Number(input[0]);
const D = Number(input[1]);
const A = Number(input[2]);

if( (K+A) < D || D === 0){
    console.log("hasu");
}else{
    console.log("gosu");
}