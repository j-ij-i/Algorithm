import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638 {
	static int map[][];
	static int result, X, Y, Cheezecnt, time, lastCnt;
	static boolean cheese[][];
	static boolean visited[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[X][Y];
		Cheezecnt = 0;
		time = 0;
		for (int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					Cheezecnt++;
				}
			}
		}
		while(Cheezecnt>0) {
//			for (int i = 0; i < X; i++) {
//				for (int j = 0; j < Y; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("================================");
			bfs();
			time++;
		}
		System.out.println(time);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		visited = new boolean[X][Y];
		while (!q.isEmpty()) {
			int location[] = q.poll();
			visited[location[0]][location[1]] = true;
			for (int d = 0; d < 4; d++) {
				int nx = location[0] + dx[d];
				int ny = location[1] + dy[d];
				if (nx >= 0 && ny >= 0 && nx < X && ny < Y && map[nx][ny] == 1 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
				}else if(nx >= 0 && ny >= 0 && nx < X && ny < Y && map[nx][ny] == 1 && visited[nx][ny] == true) {
					map[nx][ny] = 0;
					Cheezecnt--;
				}else if(nx >= 0 && ny >= 0 && nx < X && ny < Y && map[nx][ny] == 0 && visited[nx][ny] == false) {
					q.add(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}
		}
	}

}
