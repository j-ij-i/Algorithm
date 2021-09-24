import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054_가장긴바이토닉부분 {
	static int dp_left[];
	static int dp_right[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp_left = new int[N+1];
		dp_right = new int[N+1];

		dp_right[N] = 1;
		dp_left[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp_left[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp_left[i] = Math.max(dp_left[i], dp_left[j] + 1);
				}
			}
		}

		for (int i = N - 1; i > 0; i--) {
			dp_right[i] = 1;
			for (int j = N; j > i; j--) {
				if (arr[i] > arr[j]) {
					dp_right[i] = Math.max(dp_right[i], dp_right[j] + 1);
				}
			}
		}

		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			dp_left[i] += dp_right[i];
		}
		
		for(int i=1;i<=N;i++) {
			if(dp_left[i] > max) {
				max = dp_left[i];
			}
		}
		
		System.out.println(max-1);
	}

}
