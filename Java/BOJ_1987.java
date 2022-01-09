package algo_0110;

import java.io.*;
import java.util.*;

public class BOJ_1987 {
	static int R,C,MAX;
	static char arr[][];
	static int dx[] = {-1,0,0,1};
	static int dy[] = {0,1,-1,0};
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		MAX = Integer.MIN_VALUE;
		for(int i = 0 ; i < R ;i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		visited = new boolean[26];
		dfs(0, 0, 1);
		System.out.println(MAX);
	}
	private static void dfs(int i, int j, int m) {
		// TODO Auto-generated method stub
		visited[arr[i][j]-'A'] = true;
		for(int d = 0 ; d < 4 ; d++) {
			int nx = dx[d]+i;
			int ny = dy[d]+j;
			if(isArea(nx,ny)) {
				if(!visited[arr[nx][ny]-'A']) {
					dfs(nx,ny,m+1);
				}
			}
		}
		visited[arr[i][j]-'A'] = false;
		MAX = Math.max(MAX, m);
	}
	private static boolean isArea(int nx, int ny) {
		// TODO Auto-generated method stub
		if(nx>=0 && ny >=0 && nx<R && ny<C) return true;
		return false;
	}
}