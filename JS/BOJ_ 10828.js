
let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
//let input = "14\npush 1\n\npush 2\ntop\nsize\nempty\npop\npop\npop\nsize\nempty\npop\npush 3\nempty\ntop";
//let input ="7\npop\ntop\npush 123\ntop\npop\ntop\npop\n";
//input = input.toString().split('\n');
let arr = [];
let sum ='';
for(let i = 0; i <= (Number(input[0])+1); i++){
    stack(input[i]);
}
console.log(sum);
 
function stack(i){
let element = i.split(' ');
switch(element[0]){
    case "push":
        arr.push(Number(element[1]))
        break;
    case "pop":
        if(Array.isArray(arr) && arr.length === 0)
            sum += "-1"+"\n";
        else{     
            let popped = arr.pop();
            sum += popped+"\n";
        }
        break;
    case "size":
        sum += arr.length+"\n";          
        break;
    case "empty":
        if(arr.length === 0)
            sum += "1"+"\n";     
        else
            sum += "0"+"\n";                 
        break;
    case "top": 
    if(arr.length === 0)
        sum += "-1"+"\n";     
    else
        sum += arr[arr.length-1]+"\n";       
        break;     
}
}