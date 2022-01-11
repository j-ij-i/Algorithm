import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520 {
	static int dx[] = {0,1,0};
	static int dy[] = {1,0,-1};
	static int M, N, totalnum;
	static int arr[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		totalnum=0;
		visited = new boolean[M][N];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.println(totalnum);
	}
	private static void dfs(int i, int j) {
		visited[i][j] = true;
		if(i == M-1 && j == N-1) {
			totalnum++;
		}
		for(int d = 0 ; d < 3 ; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			if(isArea(nx,ny) && !visited[nx][ny] && arr[nx][ny] < arr[i][j]) {
				dfs(nx,ny);
			}
		}
		visited[i][j] = false;
	}
	private static boolean isArea(int nx, int ny) {
		// TODO Auto-generated method stub
		if(nx >= 0 && ny >= 0 && nx <M && ny < N) return true;
		return false;
	}

}
