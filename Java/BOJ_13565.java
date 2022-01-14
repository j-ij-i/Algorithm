package algo_0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13565 {
	static int[][]arr;
	static int M,N;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		visited = new boolean[M][N];
		for(int i = 0 ; i < M ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		//bfs
		Queue<int []> queue = new LinkedList<>();
		boolean flag = false;
		for(int i = 0 ; i < M; i++) {
			if(arr[0][i] == 0 && !visited[0][i]) {
				queue.add(new int[] {0,i});
				visited[0][i] = true;
				while(!queue.isEmpty()) {
					int loca[] = queue.poll();
					if(loca[0] == M-1) {
						flag = true;
						break;
					}
					for(int d = 0 ; d < 4 ;d++) {
						int nx = dx[d] + loca[0];
						int ny = dy[d] + loca[1];
						if(isArea(nx,ny) && arr[nx][ny]==0 && !visited[nx][ny]) {
							visited[nx][ny] = true;
							queue.add(new int[] {nx, ny});
						}
					}
				}
			}
			if(flag) break;	

		}
	
		if(flag) System.out.print("YES");
		else System.out.println("NO");
	}
	private static boolean isArea(int nx, int ny) {
		if(nx>=0 && ny >= 0 && nx<M && ny<N) return true;
		return false;
	}

}
