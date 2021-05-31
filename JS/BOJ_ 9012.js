let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
//let input = "6\n(())())\n(((()())()\n(()())((()))\n((()()(()))(((())))()\n()()()()(()()())()\n(()((())()(";
//let input = "3\n((\n))\n())(()";
//input = input.split('\n');
let sum ='';
for(let i = 1; i <= input[0] ; i++){
    while(true){
        let idx = input[i].indexOf("()");   
        if (idx !== -1) {
            input[i] = input[i].slice(0, idx)+input[i].slice(idx+2, input[i].length);
        }else if(idx === -1){
            if(input[i].length === 0){
                sum += "YES\n";
                break;
            }else{
                sum += "NO\n";
                break;
            }
        }
    }
}

console.log(sum);