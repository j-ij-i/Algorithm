const fs = require("fs");
let input = fs.readFileSync("./input.txt").toString();
console.log(input);
input = input.split("\n");
console.log(input);

const testCaseNum = +input[0];
console.log("testCaseNum : ", testCaseNum);
for (let i = 1; i <= testCaseNum; ++i) {
  const arr = input[i].split(" ");
  console.log("arr : ", arr);
  break;

  let totalSum = 0;
}
