//두 정수 사이의 합

function solution(a, b) {
  var answer = 0;
  let sum = 0;
  if((a-b)!==0){
      if(a>b){
          sum = 0;
          for(let i = b ; i<=a ; i++){
              sum += i;
          }
      }else if(b>a){
          sum = 0;
          for(let i = a ; i<=b ; i++){
              sum += i;
          }
      }
      answer = sum;
  }else{
      answer = a;
  }
  return answer;
}