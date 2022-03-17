function solution(bridge_length, weight, truck_weights) {
  var answer = 0;
  let array = Array.from({ length: bridge_length }, () => 0);

  while (truck_weights.length > 0 || 0 < array.reduce((a, b) => a + b, 0)) {
    let sum = array.reduce((a, b) => a + b, 0);
    if (truck_weights.length > 0) {
      //나갈 트럭이 있고
      if (weight >= sum - array[0] + truck_weights[0]) {
        array.shift();
        array.push(truck_weights.shift());
      } else {
        //무게가 안되면 그냥 다리위에 있는 애들 앞으로 가기
        array.shift();
        array.push(0);
      }
    } else {
      //나갈트럭이 없으면 그냥 다리위에 있는 애들 앞으로 가기
      array.shift();
      array.push(0);
    }
    answer++;
  }
  return answer;
}
