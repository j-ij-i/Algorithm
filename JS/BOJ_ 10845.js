let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let input = "15\npush 1\npush 2\nfront\nback\nsize\nempty\npop\npop\npop\nsize\nempty\npop\npush 3\nempty\nfront";
input = input.split('\n');
let sum = '';
let queue = new Array;
for(let i = 1 ; i <= input[0] ; i++){
    let arr = input[i].split(" ");
    switch(arr[0]){
        case "push":
            queue.push(Number(arr[1]));
            break;
        case "pop":
            if(queue.length !== 0){
                sum+= queue[0]+"\n";
                queue = queue.slice(1, queue.length);
            }else if(queue.length === 0){
                sum += "-1\n";
            }break;            
        case "size":
            sum += queue.length+"\n";
            break;
        case "empty":
            if(queue.length !== 0){
                sum += "0\n";
            }else if(queue.length === 0){
                sum += "1\n";
            }break;
        case "front":
            if(queue.length !== 0){
                sum += queue[0]+"\n";
            }else if(queue.length === 0 ){
                sum += "-1\n";
            }break;          
        case "back":
            if(queue.length !== 0){
                sum+= queue[queue.length-1]+"\n";
            }else if(queue.length === 0){
                sum+= "-1\n";
            }break;
    }
}
console.log(sum);
