let input = require('fs').readFileSync('/dev/stdin').toString().split(' ');
//input = input.split(' ');
function Solution(input){
    if(Number(input[1])>=Number(input[2]))
    {
        return -1;
    }else{
        let sellamount = Number(input[0]);
        let makeitem = Number(input[1]);
        let profit = Number(input[2]);
        let i = 1;
        let x = 0, y = 0;
        while(true){
            x = makeitem * i;
            y = profit * i;
            if(y>(sellamount+x)){
                return i;
            }
            i++;
        }
    }
}

console.log(Solution(input));