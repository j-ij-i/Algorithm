//같은 숫자는 싫어
function solution(arr)
{
    var answer = '';
    let AnsArr = [];
    for(let i = 0; i<arr.length ; i++){
        let j = AnsArr.length-1;
        if(AnsArr[j] !== arr[i]){
            AnsArr.push(arr[i]);
        }
    }
    return AnsArr;
}