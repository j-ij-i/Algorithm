function solution(numbers) {
  var answer = '';
  numbers.sort(function (a, b) {
    const ca = parseInt(a.toString() + b.toString());
    const cb = parseInt(b.toString() + a.toString());
    return cb - ca;
  });

  answer = numbers.join('');
  if (answer[0] == 0) {
    answer = '0';
  }
  return answer;
}
