let input = require('fs').readFileSync('/dev/stdin').toString();
let sum = '';

function sq(x , y, input){
        if(x % 3 === 1 && y % 3 === 1){
            sum += " ";
            console.log(" x="+x+" y="+y+" input= "+input);
        } else {
            if( input === 1 ){
                sum += '*';
                console.log("* x="+x+" y="+y);
            }else
            sq( Math.floor(x/3), Math.floor(y/3), Math.floor(input/3));
        }
};

for(let i = 0 ; i < input ; i++){
    for(let j = 0; j < input ; j++){
        sq(i,j,input);
    }
    sum += '\n';
}
console.log(sum);