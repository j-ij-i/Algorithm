function solution(participant, completion) {
  const hashMap = new Map();
  //Map은 key와 Value로 나누어짐
  participant.forEach((p) => {
    let isExist = hashMap.get(p);
    //hashMap에 현재 찾는 participant의 p가 존재하면 갯수가 isExist에 들어감.
    console.log(isExist);
    if (!isExist) {
      // 만약 존재하지 않는다면
      hashMap.set(p, 1); //그대로 p와 갯수 1을 넣어줌
      return;
    }
    hashMap.set(p, isExist + 1); // p가 1개이상 존재한다면 현재갯수(isExist)+1을 value 값으로 넣어줌
  });
  for (const c of completion) {
    let Num = hashMap.get(c); //만약 c가 hashMap에 존재하면 갯수를 Num에 넣어주고
    hashMap.set(c, Num - 1); //-1만큼 value값으로 그대로 hashMap에 넣어줌
  }
  for (const [key, value] of hashMap) {
    //만약 0이 아닌 값이 있다면 그게 완주하지 못한 값
    if (value !== 0) {
      return key;
    }
  }
}

function solution(participant, completion) {
  participant.sort();
  completion.sort();
  for (var i = 0; i < participant.length; i++) {
    if (participant[i] !== completion[i]) {
      return participant[i];
    }
  }
}
