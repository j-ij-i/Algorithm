function solution(progresses, speeds) {
  var answer = [];
  while (progresses.length > 0) {
    for (let i = 0; i < progresses.length; i++) {
      progresses[i] += speeds[i];
    }
    let gin = 0;
    while (progresses[0] >= 100) {
      speeds.shift();
      progresses.shift();
      gin++;
    }
    if (gin != 0) answer.push(gin);
  }
  return answer;
}
