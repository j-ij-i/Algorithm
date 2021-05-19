let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

const a = input();
const b = input();
const aLength = a.length;
const bLength = b.length;

const dp = Array.from(Array(aLength + 1), () => Array(bLength + 1).fill(""));
for (let i = 1; i < aLength + 1; i++) {
  for (let j = 1; j < bLength + 1; j++) {
    if (a[i - 1] === b[j - 1]) {
      dp[i][j] = dp[i - 1][j - 1] + b[j - 1];
    } else {
      if (dp[i][j - 1].length > dp[i - 1][j].length) {
        dp[i][j] = dp[i][j - 1];
      } else {
        dp[i][j] = dp[i - 1][j];
      }
    }
  }
}

if (dp[aLength][bLength].length == 0) {
  console.log(0);
} else {
  console.log(dp[aLength][bLength].length);
  console.log(dp[aLength][bLength]);
}