class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        loop:
        for(int i = 1 ; i< phone_book.length; i++){
            for(int x = 0 ; x <= (phone_book[i].length())-(phone_book[0].length()); x++){
             int cnt = 0 ;
               for(int n = 0 ; n < phone_book[0].length() ; n++){
                 if(phone_book[i].charAt(x+n)== phone_book[0].charAt(n)){
                    cnt++;
                 }
               }
                if(cnt == phone_book[0].length()){
                    answer = false;
                    break loop;              
                }
            }
        }
        return answer;
    }
}