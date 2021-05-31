let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
// let input = "15\npush_back 1\npush_front 2\nfront\nback\nsize\nempty\npop_front\npop_back\npop_front\nsize\nempty\npop_back\npush_front 3\nempty\nfront";
// let input = "22\nfront\nback\npop_front\npop_back\npush_front 1\nfront\npop_back\npush_back 2\nback\npop_front\npush_front 10\npush_front 333\nfront\nback\npop_back\npop_back\npush_back 20\npush_back 1234\nfront\nback\npop_back\npop_back"
// input = input.split('\n');
let sum = '';
let deque = new Array;

for(let i = 1 ; i <= input[0] ; i++){
    let arr = input[i].split(" ");
    switch(arr[0]){
        case "push_front":
            deque.splice(0, 0, arr[1]);
            break;
        case "push_back":
            deque.push(Number(arr[1])) ;
            break;
        case "pop_front":
            if(deque.length !== 0){
                sum+= deque.shift()+"\n";
            }else if(deque.length === 0){
                sum += "-1\n";
            }break;
        case "pop_back":
            if(deque.length !== 0){
                sum+= deque.pop()+"\n";
            }else if(deque.length === 0){
                sum+= "-1\n";
            }break;
        case "size":
            sum+= deque.length+"\n";
            break;
        case "empty":
            if(deque.length !== 0){
                sum+= "0\n";
            }else if(deque.length === 0){
                sum+= "1\n";
            }break;
        case "front":
            if(deque.length !== 0){
                sum+= deque[0]+"\n";
            }else if(deque.length === 0){
                sum+= "-1\n";
            }break;
        case "back":
            if(deque.length !== 0){
                sum+= deque[deque.length-1]+"\n";
            }else if(deque.length === 0){
                sum+= "-1\n";
            }break;
    }
}
console.log(sum);
