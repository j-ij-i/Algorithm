function drone(){
    const input = 3;
    let result=0;
    if(input%2){
        for(let i = 1; i <= input ; i++){
            if(i%2){
                result += (4*i);
                console.log(i+"a"+result);
            }
        }
        return result;
    }else{        
        for(let i = 1; i <= input ; i++){
        if(!(i%2)){
            result += (4*i);
            console.log(i+"b"+result);
        }
    }
    return result+1;
        
    }

}

console.log(drone());