function solution(left, right) {
  let answer = 0;

  for (let i = left; i <= right; i++) {
    let cnt = 0;
    for (let j = 1; j <= i; j++) {
      if (i % j === 0) {
        cnt++;
      }
    }
    if (cnt % 2 === 0) answer += i;
    else answer -= i;
  }
  return answer;
}
// 제곱근이 정수일 때 n의 제곱이 되니까 Math.sqrt
