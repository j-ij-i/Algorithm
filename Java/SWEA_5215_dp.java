import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_dp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1 ; i<=T ; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[] Cal = new int[N+1];
			int[] flavor = new int[N+1];
			
			for(int j = 1; j <= N ; j++) {
				st = new StringTokenizer(br.readLine());
				flavor[j]= Integer.parseInt(st.nextToken());
				Cal[j]  = Integer.parseInt(st.nextToken());
			}
			
			int[] DP = new int[L+1];
			
			for(int t = 1 ; t <= N ; t++) {
				for(int w = L; w >= Cal[t]; w--) {
						DP[w] = Math.max(flavor[t]+DP[w-Cal[t]], DP[w]);
				}
			}
			sb.append("#").append(i).append(" ").append(DP[L]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
