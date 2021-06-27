//문자열 다루기 기본

function solution(s) {
  var answer = true;
  //isNaN(s);
  if(s.match(/[^0-9]/)){
    answer = false
  }
  if(s.length !== 4 && s.length !== 6){
    answer = false;
  }
  return answer;
}