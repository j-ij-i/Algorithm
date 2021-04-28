let input = require('fs').readFileSync('/dev/stdin').toString();
input = input.replace(/[^a-zA-Z]/g, ""); 
let arr = [];
let UpperApb = input.toUpperCase();

for(let i = 0 ; i < input.length ; i++){
    arr.push(UpperApb[i]);
}
arr.sort();
let isSame = false;
let maxNum = 0;
let maxStr = "";
let currentStr = "";

for(let i = 0; i<arr.length ; i++){
    if(currentStr !== arr[i]){
    sum = 1;
    currentStr = arr[i];
    }else if(currentStr === arr[i]){
        sum++;
    }

    if( maxNum < sum){
        maxNum = sum; 
        isSame = false;   
        maxStr = arr[i];
    }else if(maxNum === sum){
    isSame = true;
    }
}
if(isSame === true){
    console.log("?");
}else{
    console.log(maxStr);
}
