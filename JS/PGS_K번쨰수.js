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
