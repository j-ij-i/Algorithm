let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let sum = 0;
for( let i = 1; i <= input[0] ; i++){
    let arr = input[i];
    let isGroup = true;
    let arrPush = [];
    let currentArr = '';
    for(let j = 0; j < arr.length ; j++){
        if( arrPush.indexOf(arr[j]) === -1){
            arrPush.push(arr[j]);
            currentArr=arr[j];
        }else if(currentArr !== arr[j] && arrPush.indexOf(arr[j]) !== -1){
            isGroup = false;
            break;
        }
    }
    if(isGroup){
        sum++;
    }
}
console.log(sum);