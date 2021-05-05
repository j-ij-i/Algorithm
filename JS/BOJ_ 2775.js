let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

input = input.split(" ");
let f = 1;
let h = 2;

for(let i = 1 ; i<=input[0] ; i++){
    let count = 0 ;
    let floor = Number(input[f]);
    for(let j = floor ; j <= floor ; j++){
        let ho = Number(input[h]);
        for(let x = 0 ; x <= ho ; x--){
            count ++;
            console.log("ho: "+ x + "floor: "+ j);
        }
    } 
    console.log(i+"i"+count+ "count");
    f += 2;
    h += 2;
}