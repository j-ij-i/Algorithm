let input = require('fs').readFileSync('/dev/stdin').toString();
input = Number(input);
function Fibonacci(i){
    if(i === 0 ){
        return 0;
    }else if( i < 2){
        return i;
    }
    return (Fibonacci(i-1) + Fibonacci(i-2));
}

console.log(Fibonacci(input));