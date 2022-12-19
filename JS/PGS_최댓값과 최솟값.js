function solution(s) {
    var answer = '';
    let arr = (s.split(" ")).map(i => parseInt(i))
    arr = arr.sort((a,b) => (a-b))
    answer = String(arr[0])+" "+String(arr[arr.length-1])
    return answer;
}