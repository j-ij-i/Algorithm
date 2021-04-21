//첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
     let sum = ('');
for(var i = 0; i<input[0]; i++){
     for(var j = 0; j<input[0]-i-1; j++){
          sum+=" ";
     }
     for(var j = 0; j<=i; j++){
          sum+="*";
     }
     sum+= "\n";
}

console.log(sum);