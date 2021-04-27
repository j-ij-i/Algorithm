let input = require('fs').readFileSync('/dev/stdin').toString();

let arr = input.split(" ");
let j = 0;
for(let i = 0 ; i < 2 ; i++){
    sum = [''];
    let num = arr[i]
    for(let j = 2 ; j >= 0 ; j--){
        sum += num[j]
    }
    arr[i] = sum;
}
if(Number(arr[0]) > Number(arr[1])){
    console.log(Number(arr[0]));
}else{
    console.log(Number(arr[1]));
}

// 
// s=(require('fs').readFileSync('dev/stdin')+'').split(' ')
// console.log(s.map(v=>+[...v].reverse().join('')).sort((a,b)=>b-a)[0])
