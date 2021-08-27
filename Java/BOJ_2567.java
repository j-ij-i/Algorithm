import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean arr[][] = new boolean[101][101];
		int N = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = x ; j< x+10; j++) {
				for(int t = y; t < y+10 ; t++) {
					arr[j][t] = true;
				}
			}
		}
		int cnt = 0;
		for(int j = 0 ; j<=100; j++) {
			for(int t = 0; t <=100 ; t++) {
				if(arr[j][t]==true && arr[j-1][t]==false)
					cnt++;
				if(arr[j][t]==true && arr[j][t-1]==false)
					cnt++;
				if(arr[j][t]==true && arr[j+1][t]==false)
					cnt++;
				if(arr[j][t]==true && arr[j][t+1]==false)
					cnt++;
			}
		}
		

		
		System.out.println(cnt);
	}

}
