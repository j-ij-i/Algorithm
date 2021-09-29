import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {
	static int N;
	static int M;
	static int startx;
	static int starty;
	static boolean flag;
	static char[][] map;
	static boolean[][][] visited;
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][64];
		flag = false;
		for(int x = 0 ; x < N ; x++) {
			String str = br.readLine();
			for(int y=0 ; y < M ; y++) {
				map[x][y] = str.charAt(y);
				if(map[x][y] == '0') {
					startx = x;
					starty = y;
				}
			}
		}
		bfs();
	}
	private static void bfs() {
		Queue<minsik> q = new LinkedList<>();
		q.add(new minsik(startx,starty,0,0));
		int x = 0;
		while(!q.isEmpty()) {
			minsik m = q.poll();
			visited[m.x][m.y][m.key]=true;
			
			if(map[m.x][m.y] == '1') {
				System.out.println(m.cnt);
				return;
			}
			
			for(int d = 0 ; d <4 ; d++) {
				int nx = m.x+dx[d];
				int ny = m.y+dy[d];
				if(isArea(nx,ny)) {
					
					//못감
					if(map[nx][ny] == '#' || visited[nx][ny][m.key] == true) {
						continue;
					}
					
					//열쇠임
					if(map[nx][ny] -'a' >= 0 && map[nx][ny]-'a' < 6) {
						int curKey = (1 << (map[nx][ny] - 'a')) | m.key;
						
						if(visited[nx][ny][curKey] == false) {
							visited[nx][ny][curKey] = true;
							visited[nx][ny][m.key] = true;
							q.add(new minsik(nx,ny, curKey ,m.cnt+1));
						}
					}
					
					//문임
					else if(map[nx][ny] -'A' >= 0 && map[nx][ny]-'A' < 6) {
						int curDoor = (1 << (map[nx][ny] - 'A')) & m.key;
						if(curDoor > 0) {
							visited[nx][ny][m.key] = true;
							q.add(new minsik(nx,ny,m.key,m.cnt+1));
						}
					}
					else {
						visited[nx][ny][m.key] = true;
						q.add(new minsik(nx,ny,m.key,m.cnt+1));
					}
				}
				
			}
		}
		System.out.println("-1");
	}
	
	
	private static boolean isArea(int nx, int ny) {
		// TODO Auto-generated method stub
		if(nx>=0 && ny >=0 && nx <N && ny <M) {
			return true;
		}else return false;
	}


	static class minsik{
		int x;
		int y;
		int key;
		int cnt;
		
		public minsik(int x, int y, int key, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
			this.cnt = cnt;
		}

	}
}
