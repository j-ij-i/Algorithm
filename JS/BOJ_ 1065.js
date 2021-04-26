let input = require('fs').readFileSync('/dev/stdin').toString();
for( let i = 1 ; i <= input; i++){
    let gap1 = 0;
    let gap2 = 0;
    if(i<100){
        sum++;
    }else if(i>=100){
        gap1 = Number(i.toString()[0]) - Number(i.toString()[1]);
        gap2 = Number(i.toString()[1]) - Number(i.toString()[2]);
        if(gap1 === gap2){
            sum++;
        }
    }
}
console.log(sum);