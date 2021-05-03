let input = require('fs').readFileSync('/dev/stdin').toString();
input = Number(input);
let i = 1;
let j = 1;
let result = 0;
let num = 0;
let order = 1;
while(true){
    result += i;
    if(result >= input){
        if(input%i === 0){
            num = i;
        }else{
            num = input%i;
        }        
        j = (i+1)-num;
        console.log(j+"/"+num);

        break;
    }else{
        console.log(order+"번째"+j+"/"+num);
        i++;
        order++;
    }
}
//정방향 역방향을 고려하지 않았을때 