import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11401 {
	static int memo[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		memo= new int[N+1];
		memo[1] = 1;
		memo[0] = 1;
		int nf = factorial(N);
		int kf = factorial(K);
		int nkf = factorial(N-K);
		
		int result = (nf/kf)/nkf;
		System.out.println(result);
	}

	private static int factorial(int n) {
		// TODO Auto-generated method stub
		if(n>=2 && memo[n]==0) {
			memo[n] = (factorial(n-1)*n)%1000000007;
		}
		return memo[n];
	}
}
