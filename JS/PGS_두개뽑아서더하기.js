function solution(numbers) {
  var answer = [];

  for (let i = 0; i < numbers.length; i++) {
    for (let j = i + 1; j < numbers.length; j++) {
      let sum = numbers[i] + numbers[j];
      if (answer.indexOf(sum) === "") {
        answer.push(sum);
      }
    }
  }
  answer.sort((a, b) => a - b);
  return answer;
}

// if(answer.find(item => item === sum ) != undefined) continue; 도 가능!
