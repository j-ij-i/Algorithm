import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static int spreadDustx[] = { 0, 0, 1, -1 };
	static int spreadDusty[] = { 1, -1, 0, 0 };
	static int map[][];
	static int clone[][];
	static int R, C, T, UpAir, DownAir;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		UpAir = Integer.MAX_VALUE;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && UpAir == Integer.MAX_VALUE) {
					UpAir = i;
				} else if (map[i][j] == -1 && UpAir != Integer.MAX_VALUE) {
					DownAir = i;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			//미세먼지 퍼지기
			Dust();
			//공기청정기 발동
			AirCircle();
		}

		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1)
					result += map[i][j];
			}
		}

		System.out.println(result);

	}

	private static void AirCircle() {
		// 윗공기순환
		// map[UpAir][0]
		for (int x = UpAir - 2; x >= 0; x--) {
			map[x + 1][0] = map[x][0];
		}
		for (int y = 1; y < C; y++) {
			map[0][y - 1] = map[0][y];
		}
		for (int x = 1; x <= UpAir; x++) {
			map[x - 1][C - 1] = map[x][C - 1];
		}
		for (int y = C - 1; y >= 1; y--) {
			map[UpAir][y] = map[UpAir][y - 1];
		}
		map[UpAir][1] = 0;
		// 아랫공기순환
		// map[DownAir][0]
		for (int x = DownAir + 2; x < R; x++) {
			map[x - 1][0] = map[x][0];
		}
		for (int y = 1; y < C; y++) {
			map[R - 1][y - 1] = map[R - 1][y];
		}
		for (int x = R - 1; x >= DownAir; x--) {
			map[x][C - 1] = map[x - 1][C - 1];
		}
		for (int y = C - 1; y >= 1; y--) {
			map[DownAir][y] = map[DownAir][y - 1];
		}
		map[DownAir][1] = 0;
	}

	private static void Dust() {
		clone = new int[R][C];
		clone[UpAir][0] = -1; //공청기 위치
		clone[DownAir][0] = -1;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1) {
					int init = map[i][j];
					if (init < 5) {
						clone[i][j] += map[i][j];
						continue;
					}
					int spdust = map[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int nx = spreadDustx[d] + i;
						int ny = spreadDusty[d] + j;
						if (isArea(nx, ny) && map[nx][ny] != -1) {
							init -= spdust;
							clone[nx][ny] += spdust;
						}
					}
					clone[i][j] += init;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = clone[i][j];
			}
		}
	}

	private static boolean isArea(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < R && ny < C)
			return true;
		return false;
	}

}
