import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
		for(int i=0; i< phone_book.length;i++) {
			for(int j=0; j< phone_book.length;j++) {
				if(i!=j && phone_book[j].indexOf(phone_book[i])==0) {
					return false;
				}
			}					
		}
		return true;
	}
}

//startsWith
class Solution {
    public boolean solution(String[] phone_book) {
       
        for(int i=0; i<phone_book.length;i++)
        {
            for(int j=i+1;j<phone_book.length;j++) {
                if(phone_book[j].startsWith(phone_book[i]))
                    return false;
            }
        }
        return true;
    }
}

//Hash map
