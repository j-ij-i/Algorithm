function solution(s) {
  let answer = '';
  
  if( (s.length%2) == 1){
      const num = Math.floor((s.length) / 2);
      answer += s[num];
  }else{
      const num = Math.floor((s.length) / 2);
      answer += s[num-1];  
      answer += s[num];
  }
  return answer;
}