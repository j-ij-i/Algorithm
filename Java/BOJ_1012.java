import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
	static boolean visited[][];
	static int arr [][];
	static int M,N, cnt;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T ; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			for(int j = 0 ; j < K ; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			}
			
			visited = new boolean[N][M];
			BFS();
//			for(int x = 0 ; x < N ; x++) {
//				for(int y = 0 ; y <M ; y++) {
//					System.out.print(arr[x][y]);
//				}
//				System.out.println();
//			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void BFS() {
		Queue<int []> q = new LinkedList<>();
		cnt = 0 ;
		for(int x = 0 ; x < N ; x++) {
			for(int y = 0 ; y < M ; y++) {
				if(visited[x][y] == false && arr[x][y] == 1) {
					cnt++;
					arr[x][y] = cnt;
					visited[x][y] = true;
					q.add(new int[]{x,y});
					while(!q.isEmpty()) {
						int location[] = q.poll();
						for(int d = 0 ; d < 4; d++) {
							int nx = location[0]+ dx[d];
							int ny = location[1]+ dy[d];
							if(nx >=0 && ny >= 0 && nx < N && ny < M) {
								if(visited[nx][ny] == false && arr[nx][ny] == 1) {
									arr[nx][ny] = cnt;
									q.add(new int[] {nx,ny});
								}
								visited[nx][ny] = true;
							}
						}
					}
				}
				
			}
		}
		
	}

}
