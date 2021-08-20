import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int X, Y, min;

	static int arr[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	static ArrayList<CCTV> ctv = new ArrayList<CCTV>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		arr = new int[X][Y];

		for (int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Y; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5) {
					ctv.add(new CCTV(i, j, arr[i][j]));
				}
			}
		}
		min = Integer.MAX_VALUE;
		detect(0, arr);
		System.out.println(min);
	}

	private static void detect(int cnt, int[][] arr) {
		int[][] visited = new int[X][Y];
		int size = 0;
		if(cnt == ctv.size()) {
			for(int i = 0 ; i < X; i++) {
				for(int j = 0 ; j <Y ; j++) {
					if(arr[i][j] == 0) {
						size++;
					}
				}
			}
			min = Math.min(min, size);
			return;
		}else {
			int n = ctv.get(cnt).num ;
			if(n ==1) {
				for(int d = 0 ; d <4 ; d++) {
					for (int i = 0; i < X; i++) {
						visited[i] = Arrays.copyOf(arr[i], Y);
					}
					int nx = ctv.get(cnt).x + dx[d];
					int ny = ctv.get(cnt).y + dy[d];
					boolean poss = true;
					while(nx >= 0 && nx < X && ny >= 0 && ny < Y && poss==true) {
						if(visited[nx][ny] == 6) {
							poss = false;
					}
					else if(visited[nx][ny] == 0) {
						visited[nx][ny] = 7;
					}
					nx += dx[d];
					ny += dy[d];
				}		
				detect(cnt+1,visited);   
				}
			}else if(n == 2){
				//2번일 경우 위아래, 왼쪽 오른쪽을 담색해야함
				//0 2 / 1 3 로 탐색해야하는데..
				for(int i = 0 ; i < 2 ; i++) {
					for (int c = 0; c < X; c++) {
						visited[c] = Arrays.copyOf(arr[c], Y);
					}
					for(int j = i ; j <4 ; j=j+2) {
						int nx = ctv.get(cnt).x;
						int ny = ctv.get(cnt).y;	
						nx += dx[j];
						ny += dy[j];
						boolean poss = true;
						while(nx >= 0 && nx < X && ny >= 0 && ny < Y && poss==true) {
							if(visited[nx][ny] == 6) {
								poss = false;
							}
							else if(visited[nx][ny] == 0) {
								visited[nx][ny] = 7;
							}
							nx += dx[j];
							ny += dy[j];
						}	
					}
					detect(cnt+1,visited);
				}
			}else if(n==3){
				for(int i = 0; i <4 ; i++) {
					for (int c = 0; c < X; c++) {
						visited[c] = Arrays.copyOf(arr[c], Y);
					}
					int imsi = i;
					for(int num = 0 ; num < 2 ; num++) {
						int nx = ctv.get(cnt).x;
						int ny = ctv.get(cnt).y;
						nx += dx[imsi];
						ny += dy[imsi];
						boolean poss = true;
						while(nx >= 0 && nx < X && ny >= 0 && ny < Y && poss==true) {
							if(visited[nx][ny] == 6) {
								poss = false;
							}
							else if(visited[nx][ny] == 0) {
								visited[nx][ny] = 7;
							}
							nx += dx[imsi];
							ny += dy[imsi];
						}
						imsi ++;
						if(imsi >= 4) {
							imsi=0;
						}

					}
					detect(cnt+1,visited);
				}
			}else if(n==4){
				for(int i = 0; i <4 ; i++) {
					for (int c = 0; c < X; c++) {
						visited[c] = Arrays.copyOf(arr[c], Y);
					}
					int imsi = i;
					for(int num = 0 ; num < 3 ; num++) {
						int nx = ctv.get(cnt).x;
						int ny = ctv.get(cnt).y;
						nx += dx[imsi];
						ny += dy[imsi];
						boolean poss = true;
						while(nx >= 0 && nx < X && ny >= 0 && ny < Y && poss==true) {
							if(visited[nx][ny] == 6) {
								poss = false;
							}
							else if(visited[nx][ny] == 0) {
								visited[nx][ny] = 7;
							}
							nx += dx[imsi];
							ny += dy[imsi];
						}
						imsi ++;
						if(imsi >= 4) {
							imsi=0;
						}

					}
					detect(cnt+1,visited);
				}
			}else if(n==5){
				for (int i = 0; i < X; i++) {
					visited[i] = Arrays.copyOf(arr[i], Y);
				}
				for(int d = 0 ; d <4 ; d++) {
					int nx = ctv.get(cnt).x;
					int ny = ctv.get(cnt).y;
					nx += dx[d];
					ny += dy[d];
					boolean poss = true;
					while(nx >= 0 && nx < X && ny >= 0 && ny < Y && poss==true) {
						if(visited[nx][ny] == 6) {
							poss = false;
						}
						else if(visited[nx][ny] == 0) {
							visited[nx][ny] = 7;
						}
						nx += dx[d];
						ny += dy[d];
					}
				}
				detect(cnt+1,visited);   
				}
			}
		}
	}

class CCTV {
	int x;
	int y;
	int num;

	public CCTV(int x, int y, int num) {
		super();
		this.x = x;
		this.y = y;
		this.num = num;
	}
}