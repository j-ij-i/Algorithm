package algo_0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	static int arr[][];
	static boolean visited[][];
	static int N, M, MAX;
	static int dx[] = {0 , 0 , -1, 1};
	static int dy[] = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		arr = new int[N][M];
		for(int x = 0; x < N ; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y = 0 ; y < M ; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		MAX = 0;
		BFS();
		for(int x = 0 ; x < N ; x++) {
		for(int y = 0 ; y <M ; y++) {
			if(arr[x][y] == 0)
				MAX = -1;
		}
	}
		System.out.println(MAX);
	}
	private static void BFS() {
		Queue<int[]> q= new LinkedList<>();
		for(int c = 0; c< N ; c++) {
			for(int r = 0 ; r<M ; r++) {
				if(arr[c][r] == 1) {
					q.add(new int[]{c,r});
					visited[c][r] = true;
				}
			}
		}
		while(!q.isEmpty()) {
			int location[] = q.poll();
			for(int d = 0 ; d<4 ; d++) {
				int nx = location[0]+dx[d];
				int ny = location[1]+dy[d];
				if(nx >= 0 && ny >= 0 && nx <N && ny < M) {
					if(arr[nx][ny] == 0 && visited[nx][ny] == false) {
						q.add(new int[]{nx,ny});
						arr[nx][ny] = arr[location[0]][location[1]]+1;
						MAX = Math.max(MAX,(arr[nx][ny]-1));
					}
					visited[nx][ny] = true;
				}
			}			
		}
	}

}
