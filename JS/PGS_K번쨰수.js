function solution(array, commands) {
  let answer = [];
  for (let i = 0; i < commands.length; i++) {
    let str = array.slice(commands[i][0] - 1, commands[i][1]);
    console.log(str);
    str.sort((a, b) => a - b);
    answer[i] = str[commands[i][2] - 1];
  }
  return answer;
}

function solution(array, commands) {
  var answer = [];
  for (let a = 0; a < commands.length; a++) {
    const i = commands[a][0] - 1;
    const j = commands[a][1] - 1;
    const k = commands[a][2];

    let Narray = array.slice(i, j + 1);
    Narray.sort((a, b) => {
      return a - b;
    });
    answer.push(Narray[k - 1]);
  }

  return answer;
}
