function solution(citations) {
  var answer = 0;
  citations.sort(function (a, b) {
    return b - a;
  });

  for (let i = 0; i < citations.length; i++) {
    if (i + 1 <= citations[i]) answer = i + 1;
    else break;
  }
  return answer;
}
