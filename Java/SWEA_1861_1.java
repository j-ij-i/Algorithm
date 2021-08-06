import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1861_1 {
	static int [][]arr; 
	static int N, Max, geo;
	static boolean [][]isChecked;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			isChecked = new boolean[N][N];
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
					f(j,t, 1, arr[j][t]);
				}
			}
			sb.append("#").append(i).append(" ").append(geo).append(" ").append(Max).append("\n");	
		}
		System.out.println(sb.toString());
		br.close();
	}
	private static void f(int j, int t, int cnt , int arrNum) {
		if(cnt > 0) {
			if(Max < cnt) {
				Max = cnt;
				geo = arr[j][t];
		}else if(Max == cnt) {
			if(geo > arr[j][t])
				geo = arr[j][t];
			}
		}
		
		for(int x = 0 ; x <4 ; x++) {
			int nx = j+dx[x];
			int ny = t+dy[x];
			if(nx < 0 || ny <0 || nx>= N || ny >= N || arrNum - arr[nx][ny] != 1) {
				continue;	
			}
			cnt = cnt+1;
			f(nx, ny, cnt, arr[nx][ny]);
		}
	}	
}
