let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
const default_mention = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
const qst ="\"재귀함수가 뭔가요?\"";
const str2 ="\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
const str3 ="마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
const str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
const final_ans = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
const close_ans = "라고 답변하였지.";
const bar = "";
let result = '';

result += default_mention+'\n';
input = Number(input);
JH(input, bar);

function JH(n, bar) {
    //기본파트
    result += bar+qst+'\n';
    //유도파트
    if(n==0){
        result += bar+final_ans+'\n';
        result += bar+close_ans+'\n';
    }else{
        result += bar+str2+'\n';
        result += bar+str3+'\n';
        result += bar+str4+'\n';
        JH(n-1,"____"+bar);
        result += bar+close_ans+'\n';
    }
}

console.log(result);