import java.io.*;
import java.util.*;

public class BOJ_11060 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int dp[] = new int[N];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		for (int i = 0; i < N - 1; i++) {
			if (dp[i] == -1) {
				continue;
			}
			for (int j = 1; j <= arr[i]; j++) {
				if (i + j < N) {
					if (dp[i + j] == -1 || dp[i + j] > dp[i] + 1) {
						dp[i + j] = dp[i] + 1;
					}
				}
			}
		}
		System.out.println(dp[N - 1]);
	}
}
