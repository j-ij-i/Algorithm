import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int dx[] = {1, 0 , -1, 0};
		int dy[] = {0, 1, 0 , -1};
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int arr[][] = new int[x+1][y+1];
		int target = Integer.parseInt(br.readLine());
		int t = 1;
		if(target > x*y) {
			System.out.println("0");
		}else {
			int tx = 1;
			int ty = 1;
			arr[tx][ty] = 1;
			int maxX = x;
			int maxY = y;
			int minX = 1;
			int minY = 1;
			
			int flag = 0;
			while(true) {
				if(t == target)break;
				ty = ty + dy[flag];
				tx = tx + dx[flag];
				arr[tx][ty] = 1;
				t++;
				
				if( (ty + dy[flag]) > maxY || (tx + dx[flag]) > maxX ||  (tx + dx[flag]) < minX || (ty + dy[flag]) < minY || arr[(tx + dx[flag])][(ty + dy[flag])] == 1) {
					flag++;
					if(flag >3) {
						flag = 0;
					}
				}
			}
			System.out.println(ty+" "+tx);
			
		}
		
	}

}
