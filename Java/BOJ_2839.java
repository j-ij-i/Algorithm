import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//
public class BOJ_2839_nd {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int divide5 = N/5; //5로 나누었을때 최대 갯수
		int divide3 = 0;
		boolean isPoss = false;
		
		for(int i = divide5 ; i>= 0 ; i--) { //5를 많이 쓰면서 3%했을때 0인 수가 최소가 됨!
			int curNum = N - (i*5);
			if((curNum%3)==0) {
				divide5 = i;
				divide3 = curNum/3;
				isPoss = true;
				break;
			}
		}
		
		if(!isPoss) {
			System.out.println("-1");
		}else {
			System.out.println(divide3+divide5);
		}
		br.close();
	}

}
