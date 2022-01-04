import java.io.*;
import java.util.*;
//미로 탐색
//https://www.acmicpc.net/problem/2178
//time
//54:50
public class BOJ_2173 {
	static int N, M, result;
	static int arr[][];
	static int dx[] = {0,1,-1,0};
	static int dy[] = {1,0,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		result = 0;
		for(int x = 0 ; x < N ; x++) {
			String str = br.readLine();
			for(int y = 0 ; y< M ; y++) {
				arr[x][y] = (str.charAt(y))-'0';
			}
		}
		bfs(0,0);
		System.out.println(result);
	}
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y,1});
		boolean visited[][] = new boolean[N][M];
		visited[0][0] = true;
		while(!queue.isEmpty()) {
			int loca[] = queue.poll();
			int lx = loca[0];
			int ly = loca[1];
			int lnum = loca[2];
			if(lx == (N-1) && ly == (M-1)) {
				result = lnum;
				break;
			}
			for(int d = 0 ; d < 4 ; d++) {
				int nx = lx + dx[d];
				int ny = ly + dy[d];
				if(isArea(nx,ny) && arr[nx][ny] == 1) {
					if(visited[nx][ny] == false) {
						visited[nx][ny] = true;
						queue.add(new int[] {nx,ny,lnum+1});
					}
				}
			}
		}
	}
	private static boolean isArea(int nx, int ny) {
		if(nx >= 0 && ny >= 0 && nx < N && ny < M) return true;
		else return false;
	}

}
