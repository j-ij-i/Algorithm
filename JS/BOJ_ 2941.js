let input = require("fs").readFileSync("/dev/stdin").toString().trim;
let croaApb = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="];
function solution(input) {
  for (let i of croaApb) {
    input = input.split(i).join("a");
  }
  return input.length;
}

console.log(solution(input));
