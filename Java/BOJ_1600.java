import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int hx[] = { 1, 2, -1, -2, 1, -2, -1, 2 };
	static int hy[] = { 2, 1, -2, -1, -2, 1, 2, -1 };
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static boolean visited[][][];
	static int map[][];
	static int W, H, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[H-1][W-1] = Integer.MAX_VALUE;
		bfs(K);
		if (map[H-1][W-1] == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(map[H-1][W-1]);
		}
	}

	private static void bfs(int houseCnt) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0, 0 });// x좌표, y좌료, 방문cnt, horse사용횟수
		visited = new boolean[H][W][K+1];
		while (!q.isEmpty()) {
			int loca[] = q.poll();
			visited[loca[0]][loca[1]][loca[3]] = true;
			if (loca[3] <= K) {
				for (int d = 0; d < 8; d++) {
					int nx = loca[0] + hx[d];
					int ny = loca[1] + hy[d];
					if (nx == (H-1) && ny == (W-1)) {
						map[nx][ny] = Math.min(map[nx][ny], loca[2]+1);
					}else if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == 0
							&& visited[nx][ny][loca[3]] == false) {
						q.add(new int[] { nx, ny, loca[2] + 1, loca[3] + 1 });
						map[nx][ny] = 3;
						visited[nx][ny][loca[3]] = true;
					}
				}
			}
			for (int d = 0; d < 4; d++) {
				int nx = loca[0] + dx[d];
				int ny = loca[1] + dy[d];
				if (nx == (H - 1) && ny == (W - 1)) {
					map[nx][ny] = Math.min(map[nx][ny], loca[2]+1);
				}else if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == 0 && visited[nx][ny][loca[3]] == false) {
						q.add(new int[] {nx, ny, loca[2] + 1, loca[3] });
						map[nx][ny] = 2;
						visited[nx][ny][loca[3]] = true;
				}
			}

		}
	}

}
