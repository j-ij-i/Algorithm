let input = require('fs').readFileSync('/dev/stdin').toString();

function Solution(input){
    let sum = 0;
    for(let i = 0 ; i < input.length ; i++){
        let num = input[i].charCodeAt();
        if(65<=num && num<=67){
            sum +=3; // 
        }else if(68<=num && num<=70){
            sum +=4; // 
        }else if(71<=num && num<=73){
            sum +=5; // 
        }else if(74<=num && num<=76){
            sum +=6; // 
        }else if(77<=num && num<=79){
            sum +=7; // 
        }else if(80<=num && num<=83){
            sum +=8; // 
        }else if(84<=num && num<=86){
            sum +=9; // 
        }else if(87<=num && num<=90){
            sum +=10; //
        }
    }
    return sum;
}

console.log(Solution(input));