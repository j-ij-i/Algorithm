//2016년

function solution(a, b) {
    var answer = '';
    const DayArr = ['THU','FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED'];
    const MonthArr = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];    
    let days = 0;
    if(a>1){
        for(let i = 0 ; i < a-1 ; i++){
            days += Number(MonthArr[i])
        }
    }
    days += b;
    answer = DayArr[days%7];
    return answer;
}

