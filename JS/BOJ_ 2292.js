let input = require('fs').readFileSync('/dev/stdin').toString();

let i = 1;
let j = 0;
while(true){
    if(input <= i+(6*j)){
        console.log(j+1);
        break;
    }else{
        i = i + 6*j;
        j++;
    }
}




// 1 7 19 37 61
//1 6 12 18 24