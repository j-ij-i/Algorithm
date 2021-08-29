import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int [102][102];  
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int minx = Integer.parseInt(st.nextToken());
			int miny = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for(int x = minx ; x<minx+width; x++) {
				for(int y = miny ; y<miny+height ; y++) {
					arr[x][y]=i;
				}
			}
		}
		
        for(int x = 1 ; x <=N ; x++) {
            int cnt = 0;
        for(int i = 0 ; i < 102; i++) {
            for(int j = 0 ; j < 102 ; j++ ) {
                if(arr[i][j]==x)
                    cnt++;
            }
            }
        System.out.println(cnt);
        }

	}

}
