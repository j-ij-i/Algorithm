import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2648 {
	static int arr[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int max, N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int x =0 ; x < N ; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y = 0; y < N ; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		max = 1;
		BFS(1);
		
		System.out.println(max);
	}
	
	private static void BFS(int i) {
		Queue<int[]> q = new LinkedList<>();
		while(true) { 
			//i층에 빗물이 쌓임
			int cnt = 0;
			boolean rainarea[][] = new boolean[N][N];
			for(int x =0 ; x < N ; x++) {
				for(int y = 0; y < N ; y++) {
					if(arr[x][y] <= i) {
						rainarea[x][y] = true;
						cnt ++;
					}
				}
			}
			if( cnt >= (N*N))
				break;
			int safe = 0;
			for(int x =0 ; x < N ; x++) {
				for(int y = 0; y < N ; y++) {
					if(rainarea[x][y] == false) {
						rainarea[x][y] = true;
						safe++;
						q.add(new int[]{x,y});
						while(!q.isEmpty()) {
							int location[] = q.poll();
							for(int d = 0 ; d <= 3; d++) {
								int nx = location[0]+dx[d];
								int ny = location[1]+dy[d];
								if(nx >= 0 && ny >= 0 && nx <N && ny < N && rainarea[nx][ny] == false) {
									q.add(new int[] {nx,ny});
									rainarea[nx][ny] = true;
								}
							}

						}
					}
				}
			}
			max = Math.max(max, safe);
			i++;
		}
	}

}
