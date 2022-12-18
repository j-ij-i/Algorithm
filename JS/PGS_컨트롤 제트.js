function solution(s) {
    var answer = 0;
    let s_arr = (s.split(" "))
    let arr = []
    for(let i = 0; i < s_arr.length ; i++){
        if (s_arr[i] === 'Z')
            arr.pop()
        else
            arr.push(parseInt(s_arr[i]))
    }

    if(arr.length>1)
        return arr.reduce((a,b) => (a+b));
    else if(arr.length==1)
        return arr[0]
    else
        return 0
}