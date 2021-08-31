import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] map;
    static int result, min, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0; j <M ;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		BFS(0, 0);
		
		System.out.println(map[N-1][M-1]);
	}
	private static void BFS(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		
		while(!que.isEmpty()) {
			int location[] = que.poll();
			visited[x][y] = true;
			
			for(int d = 0 ; d <4 ; d++) {
				int nx = location[0]+dx[d];
				int ny = location[1]+dy[d];
				
				if(nx >= 0 && ny >= 0 && nx <N && ny < M) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						que.add(new int[] {nx,ny});
						visited[nx][ny] = true;
						map[nx][ny] = map[location[0]][location[1]]+1;
					}
				}
			}
		}		
	}
}
