let input = require('fs').readFileSync('/dev/stdin').toString();
input = Number(input);
let i = 1;
let j = 1;
let curnum = 0;
let num = 0;
let pastnum = 0;
while(true){
    curnum = pastnum + i;
    if(curnum >= input && pastnum < input){
        if((input-pastnum)%i === 0){
             num = i;
         }else{
             num = (input-pastnum)%i;
         }        
         j = (i+1)-num;
         if(i%2){
            console.log(j+"/"+num);
         }
         else{      
            console.log(num+"/"+j);
         }
             break;
    }else{
        i++;
        pastnum = curnum;
    }
}