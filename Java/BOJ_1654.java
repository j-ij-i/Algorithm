import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int arr [] = new int[K];

		for(int i = 0 ; i < K ; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		Arrays.sort(arr);
		long max = arr[K-1];
		long min = 1;
		long mid = 0;
		
		while(max >= min) {
			mid = (max + min)/2;
			long allCount = 0;
			for(int j = 0 ; j < arr.length ; j++) {
				allCount += arr[j] / mid;
			}
			if(allCount >= N) {
				min = mid +1;
			}else if(allCount < N) {
				max = mid -1;
			}
		}
		System.out.println(max);
	}

}
