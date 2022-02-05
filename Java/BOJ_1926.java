import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[n][m];
		int cnt=0;
		int max=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] ==1 && !visit[i][j]) {
					max = Math.max(max, bfs(j,i));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visit[y][x] = true;
		int size = 1;
		while(!q.isEmpty()) {
			int[] loca = q.poll();
			for(int d=0; d<4; d++) {
				int nx = loca[0]+dx[d];
				int ny = loca[1]+dy[d];
				if(nx<0 || ny<0 || nx>m-1 || ny>n-1) continue;
				if(visit[ny][nx]) continue;
				if(map[ny][nx] == 1) {
					size++;
					visit[ny][nx] = true;
					q.add(new int[] {nx,ny});
				}
			}
		}
		return size;
	}
}