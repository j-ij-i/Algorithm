import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int arr[][] = new int[100][100];
		int cnt = 0;
		for(int i = 0 ; i <4 ; i++) {
		st = new StringTokenizer(br.readLine());
		int miny = Integer.parseInt(st.nextToken());
		int minx = Integer.parseInt(st.nextToken());
		int maxy = Integer.parseInt(st.nextToken());
		int maxx = Integer.parseInt(st.nextToken());
		
		for(int x = minx ; x< maxx ; x++) {
			for(int y = miny ; y <maxy; y++) {
				if(arr[x][y] != 1) {
					cnt++;
					arr[x][y] = 1;
				}
			}
		}
		}
		System.out.println(cnt);
	}

}
