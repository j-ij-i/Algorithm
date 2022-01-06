import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583 {
	static int M,N,K;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int arr[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[M+1][N+1];
		visited = new boolean[M+1][N+1];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());		
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int x = x1 ; x < x2 ; x++) {
				for(int y = y1 ; y <y2 ; y++) {
					visited[y][x] = true;
				}
			}
		}
		for(int x = 0 ; x < M ; x++) {
			for(int y = 0 ; y<N ;y++) {
				if(visited[x][y] == true) System.out.print('X');
				else System.out.print('O');
			}
			System.out.println();
		}
		bfs();
		
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<int []> queue = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int areanum = 0;
		int area = 0;
		for(int i = 0 ; i <= M ; i++) {
			for(int j = 0 ; j <= N ; j++) {
				if(!visited[j][i]) {
					area = 0;
					areanum++;
					queue.add(new int[] {i,j});
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						int loca[] = queue.poll();
						area++;
						for(int d = 0 ; d< 4 ; d++) {
							int nx = dx[d]+loca[0];
							int ny = dy[d]+loca[1];
							if(isArea(nx,ny) && !visited[nx][ny]) {
								visited[nx][ny] = true;
								queue.add(new int[] {nx,ny});
							}
						}
					}
				}
				pq.add(area);
			}
		}
		System.out.println(areanum);
		while(!pq.isEmpty()) {
			System.out.print(pq.poll());
			System.out.print(" ");
		}
		
	}
	private static boolean isArea(int nx, int ny) {
		// TODO Auto-generated method stub
		if(nx>= 0 && ny >= 0 && nx <= M && ny <= N) return true;
		return false;
	}
}
