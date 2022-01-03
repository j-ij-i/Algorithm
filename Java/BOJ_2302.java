import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class BOJ_2302 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int dp[] = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		int result = 1;
		int before = 0;
		int arr[]= new int[M];
		for(int i = 0 ; i < M ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for (int i = 0; i < M; i++) {
			int cur = arr[i];
			result *= dp[cur - before - 1];
			before = cur;
		}
		result *= dp[N - before];
		System.out.println(result);
	}

}
