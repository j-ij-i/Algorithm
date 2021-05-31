let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
// let input = "8\n4\n3\n6\n8\n7\n5\n2\n1";
// let input ="4\n2\n3\n1\n4"
// let input = "5\n1\n2\n5\n3\n4";
// let input = "1\n1\n"
// let input = "3\n1\n2\n3"
// let input = "2\n2\n1"
// let input = "3\n3\n1\n2"
// let input = "3\n3\n2\n1"
// let input = "3\n2\n3\n1"
// input = input.split('\n');
let arr = new Array;
let sum = '';
let j = 1;
let isfirst = true;
let ispossible = true;
for(let i = 1; i<=input[0]; i++){
    while(true){
        if(arr.length === 0){
            if(isfirst){
                sum += "+\n";
                isfirst = false;
            }
            arr.push(j);           
        }
        let num = arr.pop();
        if(Number(input[i]) === num){
            sum += "-\n";
            break;
        }else if(num < Number(input[i])){
            arr.push(num);
            sum += "+\n";
            j++;
            arr.push(j);
        }else if(num > Number(input[i])){
            ispossible = false;
            break; 
        }
    }
    if(!ispossible){
        break;
    }
}

if(ispossible){
    console.log(sum);
}else if(!ispossible){
    console.log("NO");
}