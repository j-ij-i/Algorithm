import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861 {
	static int [][]arr; 
	static int N, Max, geo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int j = 0 ; j < N ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int t = 0 ; t < N ; t++) {
					arr[j][t] = Integer.parseInt(st.nextToken());
				}
			}
			Max = 0;
			geo = 0;
			for(int j = 0 ; j < N ; j++) {
				for(int t = 0 ; t< N ; t++) {
					f(j,t, arr[j][t], 1);
				}
			}
			sb.append("#").append(i).append(" ").append(geo).append(" ").append(Max).append("\n");
		}
		System.out.println(sb.toString());
	
	}
	private static void f(int j, int t, int arrNum, int cnt) {
		if(cnt>1) {
			if(j>=0 && t>=0 && j < N && t< N && cnt>0 && arrNum - arr[j][t] == 1) {
				if(Max<cnt) {
					Max = cnt;
					geo = arr[j][t];
				}else if(Max == cnt) {
					if(geo > arr[j][t])
						geo = arr[j][t];
				}
			}else{
				return;
			}
		}
		f(j, t-1, arr[j][t], cnt+1);
		f(j, t+1, arr[j][t], cnt+1);
		f(j+1, t, arr[j][t], cnt+1);
		f(j-1, t, arr[j][t], cnt+1);
	}
	
}
