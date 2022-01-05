import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//24:57
//적록색맹
//https://www.acmicpc.net/problem/10026
public class BOJ_10026 {
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static char arr[][];
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		bfs();

	}

	private static void bfs() {
		// 적록색맹 x
		boolean visited1[][] = new boolean[N][N];
		int grX = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited1[i][j]) {
					grX++;
					char alpha1 = arr[i][j];
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { i, j });
					visited1[i][j] = true;
					while (!queue.isEmpty()) {
						int loca[] = queue.poll();
						for(int d = 0 ; d < 4 ; d++) {
							int nx = loca[0]+dx[d];
							int ny = loca[1]+dy[d];
							if(isArea(nx,ny) && !visited1[nx][ny] && arr[nx][ny] == alpha1) {
								visited1[nx][ny] = true;
								queue.add(new int[] {nx,ny});
							}
						}
					}
				}
			}
		}

		// 적록색맹 O
		boolean visited2[][] = new boolean[N][N];
		int grO = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited2[i][j]) {
					grO++;
					char alpha2 = arr[i][j];
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { i, j });
					visited2[i][j] = true;
					while (!queue.isEmpty()) {
						int loca[] = queue.poll();
						for(int d = 0 ; d < 4 ; d++) {
							int nx = loca[0]+dx[d];
							int ny = loca[1]+dy[d];
							if(isArea(nx,ny) && !visited2[nx][ny]) {
								if(alpha2 == 'B' && 'B' == arr[nx][ny]) {
									visited2[nx][ny] = true;
									queue.add(new int[] {nx,ny});
								}else if(alpha2 != 'B' && 'B' != arr[nx][ny]) {
									visited2[nx][ny] = true;
									queue.add(new int[] {nx,ny});
								}
							}
						}
					}
				}
			}
		}
		System.out.print(grX+" "+grO);

	}

	private static boolean isArea(int nx, int ny) {
		if(nx>=0 && ny >= 0 && nx < N && ny < N) return true;
		return false;
	}

}
