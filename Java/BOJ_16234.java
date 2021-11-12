package algo_1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;
		while (true) {
			int unitCnt = 0;
			boolean visited[][] = new boolean[N][N];
			int varr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean flag = false;
					if (visited[i][j] == false) {
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] { i, j });
						visited[i][j] = true;
						while (!q.isEmpty()) {
							int loca[] = q.poll();
							for (int d = 0; d < 4; d++) {
								int nx = loca[0] + dx[d];
								int ny = loca[1] + dy[d];
								if (nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny] == false) {
									if (Math.abs(map[nx][ny] - map[loca[0]][loca[1]]) >= L
											&& Math.abs(map[nx][ny] - map[loca[0]][loca[1]]) <= R) {
										if (flag == false) {
											flag = true;
											unitCnt++;
											varr[i][j] = unitCnt;
										}
										varr[nx][ny] = unitCnt;
										visited[nx][ny] = true;
										q.add(new int[] { nx, ny });
									}
								}
							}
						}
					}
				}
			}

			if (unitCnt == 0) {
				break;
			} else {
				for (int i = 1; i <= unitCnt; i++) {
					int sum = 0;
					int unitcnt = 0;

					for (int x = 0; x < N; x++) {
						for (int y = 0; y < N; y++) {
							if(varr[x][y]==i) {
								sum += map[x][y];
								unitcnt++;
							}
						}
					}
	
					int avgres = sum / unitcnt;

					for (int x = 0; x < N; x++) {
						for (int y = 0; y < N; y++) {
							if(varr[x][y]==i) {
								map[x][y] = avgres;
							}
						}
					}
				}
				day++;
			}

		}

		System.out.println(day);

	}

}
