import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		long Max = 0;
		
		for(int i = 0 ; i < T ; i++) {
			int N = Integer.parseInt(br.readLine());
			Max = Integer.MIN_VALUE;
			int RES = 0;
			long[] arr = new long[N];
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for(int x = 1 ; x <= N ; x++) {
				if(arr[N-x]>Max) {
					Max = arr[N-x];
				}else {
					RES +=(Max - arr[N-x]);
				}
			}
			System.out.println(RES);
		}	
	}

	
}
