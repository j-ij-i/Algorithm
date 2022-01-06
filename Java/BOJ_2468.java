import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//30:09
//안전영역
//https://www.acmicpc.net/problem/2468

public class BOJ_2468 {
	static int arr[][];
	static int N, MAX, areaMax;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		MAX = Integer.MIN_VALUE;
		areaMax= Integer.MIN_VALUE;
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				MAX = Math.max(arr[i][j], MAX);
			}
		}
		bfs();
		System.out.println(areaMax);
		
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<int[]> queue = new LinkedList<>();
		
		for(int m = 0; m <= MAX ; m++) {
			int copyarr[][] = new int[N][N];
			boolean visited[][] = new boolean[N][N];
			for(int i = 0 ; i< N ; i++) {
				for(int j = 0 ;j < N ;j++) {
					copyarr[i][j] = arr[i][j];
					if(copyarr[i][j] <= m) {
						visited[i][j] = true;
					}
				}
			}
			int result = 0;
			for(int i = 0 ; i< N ; i++) {
				for(int j = 0 ;j < N ;j++) {
					if(!visited[i][j]) {
						queue.add(new int[] {i,j});
						result++;
						visited[i][j] = true;
						while(!queue.isEmpty()) {
							int loca[] = queue.poll();
							for(int d = 0 ; d < 4 ; d++) {
								int nx = dx[d] + loca[0];
								int ny = dy[d] + loca[1];
								if(isArea(nx,ny) && !visited[nx][ny]) {
									visited[nx][ny] = true;
									queue.add(new int[] {nx,ny});
								}
							}
						}
					}
				}
			}
			areaMax = Math.max(result, areaMax);
			
		}
	
		
	}
	private static boolean isArea(int nx, int ny) {
		// TODO Auto-generated method stub
		if(nx >= 0 && ny >= 0 && nx < N && ny < N) return true;
		return false;
	}

}
