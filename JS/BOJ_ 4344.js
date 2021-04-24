let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
for(let i = 1 ; i<= input[0]; i++){
    let num = input[i].split(" ");
    let sum = 0;
    let avg = 0;
    let allnum = Number(num[0]);
    for( let j = 1; j<= allnum ; j++){
        sum += Number(num[j])
    }
    avg = sum / allnum;
    let overAvg = 0;
    for( let j = 1; j<= allnum ; j++){
        if(avg < Number(num[j])){
            overAvg++;
        }
    }
    let result = ((overAvg/allnum)*100).toFixed(3);
    console.log(result+"%");
}