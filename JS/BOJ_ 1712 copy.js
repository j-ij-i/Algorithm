let input = require('fs').readFileSync('/dev/stdin').toString().split(' ');
input = input.split(' ');
if(Number(input[1]) >= Number(input[2])){
    console.log(-1);
}else{
    let sellamount = Number(input[0]);
    let makeitem = Number(input[1]);
    let profit = Number(input[2]);
    let i = 1, x = 0, y = 0;
    while(true){
        x = makeitem * i;
        y = profit * i;
        if(y>(sellamount+x)){
            console.log(i);
        }
        i++;
    }
}