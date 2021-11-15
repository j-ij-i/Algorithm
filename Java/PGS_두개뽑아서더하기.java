import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> hashset = new HashSet<>();
        
        for(int i = 0 ; i <numbers.length ; i++){
            for(int j = i+1 ; j < numbers.length ; j++){
                hashset.add(numbers[i]+numbers[j]);       
            }
        }
        Iterator iterator = hashset.iterator();
        int answer[] = new int[hashset.size()];
        
        for(int i = 0 ; i < hashset.size(); i++){
            answer[i] = (int)iterator.next();
        }
        Arrays.sort(answer);
        return answer;
    }
}