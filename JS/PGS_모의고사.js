function solution(answers) {
  var answer = [];

  let a = 0;
  let anum, bnum, cnum;
  let b = 0;
  let c = 0;
  let max = 0;
  for (let i = 0; i < answers.length; i++) {
    //1번 수포자
    anum = (i + 1) % 5;
    if (anum === 0) anum = 5;
    if (anum === answers[i]) a++;

    //2번 수포자
    if ((i + 1) % 2 === 1) {
      bnum = 2;
    } else {
      bnum = Math.floor((i + 1) / 2) % 4;
      if (bnum === 0) bnum = 4;
      if (bnum > 1) bnum += 1;
    }
    if (bnum === answers[i]) b++;

    //3번 수포자
    cnum = Math.floor((i % 10) / 2);
    if (cnum === 0) cnum = 3;
    else if (cnum === 1) cnum = 1;
    else if (cnum === 2) cnum = 2;
    else if (cnum === 3) cnum = 4;
    else if (cnum === 4) cnum = 5;

    if (cnum === answers[i]) c++;
  }
  max = Math.max(a, b, c);
  let list = [a, b, c];
  console.log(list);
  for (let i = 0; i < 3; i++) {
    if (list[i] === max) answer.push(i + 1);
  }

  return answer;
}
