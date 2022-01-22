import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048 {
	static int dx []= {0,0,1,1};
	static int dy []= {0,1,1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int [N+1][M+1];
		int dp[][] = new int[N+1][M+1];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= M; y++) {
                dp[x][y] = Math.max(dp[x-1][y-1] + arr[x][y], 
                		Math.max(dp[x-1][y] + arr[x][y], dp[x][y-1] + arr[x][y]));
            }
        }	
		
		System.out.println(dp[N][M]);
	}

}
