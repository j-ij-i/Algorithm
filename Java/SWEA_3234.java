import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3324 {
	static boolean visited[];
	static int input[];
	static int numbers[];
	static int N,totalCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <= T ; i++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N];
			input = new int[N];
			numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< N ; j++ ) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			totalCnt = 0;
			permu(0);
			sb.append("#").append(i).append(" ").append(totalCnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void permu(int cnt) {
		if(cnt == N) {
			sub(0, 0 ,0);
			return;
		}
		for(int i = 0; i < N ; i++) {
			if(visited[i]) continue;
			numbers[cnt] = input[i];
			visited[i] = true;
			
			permu(cnt+1);
			visited[i] = false;
		}
	}
	private static void sub(int cnt, int right, int left) {
	       if(cnt == N){
	            totalCnt++;
	            return;
	        }else { 	       
	 	       sub(cnt+1, right, left+numbers[cnt]);
	 	       if(right+numbers[cnt] <= left) {
	 		       sub(cnt+1, right+numbers[cnt], left);
	 	       }
	        }
	}
}
