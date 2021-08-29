
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr [] = new int [N];
		int Max = Integer.MIN_VALUE;
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i< N ;i++) {
			sum = 0;
			if(i+K > N)break;
			for(int j = i ; j < i+K ; j++) {
				sum += arr[j];
			}
			Max = Math.max(Max, sum);
		}
		System.out.println(Max);
		
	}

}
