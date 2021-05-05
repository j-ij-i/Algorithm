let input = require('fs').readFileSync('/dev/stdin').toString();
input = Number(input);

function fac(input){
    if(input === 0){
        return 1;
    }
    if(input < 2){
        return input;
    }

    return input*fac(input-1);
}

console.log(fac(input));