let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
const T = parseInt(input.shift());
 
for (let i = 0; i < T; i++) {
const HWN = input[i].split(' ');
let H = parseInt(HWN.shift());
HWN.shift();
let N = parseInt(HWN.shift());
let roomCnt = 1;
 
while (N > H) {
roomCnt++;
N = N - H;
}
if (roomCnt < 10) {
console.log(`${N}0${roomCnt}`);
} else {
console.log(`${N}${roomCnt}`);
}
}