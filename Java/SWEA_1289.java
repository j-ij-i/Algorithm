import java.util.Scanner;

public class SWEA_1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int sum = 0 ;
		int result[] = new int[T];
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 0; test_case < T; test_case++)
		{
			sum = 0;
            String Tcase;
            Tcase = sc.next();
            char check = '1';
            char[] arr = Tcase.toCharArray();
            for(int i = 0 ; i < arr.length; i++){
            	if(arr[i] == check) {
            		sum++;
            		if(check=='1')
            			check='0';
            		else
            			check = '1';
            	}
            	
            }
            result[test_case] = sum;
            
		}
        
		for(int i = 0 ; i < result.length; i++) {
			
			System.out.printf("#%d %d%n",i+1, result[i]);
			//stringbuilder을 쓰면 더 줄어들음!
		}
	}
//int형 배열은 0으로 초기화되니까 int배열로 선언해줌!
}
