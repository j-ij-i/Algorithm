import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int ucurNum = 0;
		int dcurNum = Integer.MAX_VALUE;
		int ucnt = 0;
		int dcnt = 0;
		int MAX = Integer.MIN_VALUE;
		int MIN = Integer.MIN_VALUE;
		for(int i = 0 ; i < N ; i++) {
			int a = Integer.parseInt(st.nextToken());

			if(a >= ucurNum) {
				ucurNum = a;
				ucnt++;
			}else {
				ucurNum = a;
				ucnt = 1;
			}
			
			if( a <=dcurNum) {
				dcurNum = a;
				dcnt++;
			}else {
				dcurNum = a;
				dcnt = 1;
			}			
			MAX = Math.max(ucnt, MAX);
			MIN = Math.max(dcnt, MIN);
		}
		System.out.println(Math.max(MAX, MIN));
	}

}
