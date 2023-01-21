function solution(n) {
  var answer = 0;
  let res = "";
  while (n >= 3) {
    l = n % 3;
    n = Math.floor(n / 3);
    res = l + res;
  }
  res = String(n) + res;
  for (let i = 0; i < res.length; i++) {
    answer += Number(res[i]) * 3 ** i;
  }
  return answer;
}
