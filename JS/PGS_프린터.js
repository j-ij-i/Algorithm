function solution(priorities, location) {
  var answer = 0;
  let num = 0;
  let count = 9;
  while (answer < priorities.length) {
    let flag = false;
    for (let i = 0; i < priorities.length; i++) {
      if (priorities[i] == count) {
        if ((location = i)) num = i;
        priorities[i] = 0;
        answer++;
        flag = true;
        //중간에 나가는 방법도 생각하자룽
        break;
      }
    }
    if (!flag) count--;
    if (count == 0) break;
  }

  return num;
}
