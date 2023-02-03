function solution(d, budget) {
  var answer = 0;
  d.sort((a, b) => a - b);
  let i = 0;
  for (i = 0; i < d.length; ) {
    if (d[i] + answer > budget) {
      break;
    } else {
      answer += d[i];
      i += 1;
    }
  }
  return i;
}
