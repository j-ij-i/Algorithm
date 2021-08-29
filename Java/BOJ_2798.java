import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {
	static int N,M,MAX ;
	static boolean visited[];
	static int arr [];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		arr= new int [N]; 
		MAX = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i <N  ; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		comb(0,0,0);
		System.out.println(MAX);
	}

	private static void comb(int i, int cnt ,int sum) {
		if(sum <= M && cnt == 3) {
				MAX = Math.max(sum, MAX);
				return;
		}else if(sum > M ) return;
		else if(cnt > 3 )return;
		else if(i >= N) return;
		else {
		visited[i] = true;
		comb(i+1, cnt+1, sum+arr[i]);
		visited[i] = false;
		comb(i+1, cnt, sum);
		}
		
	}

}
