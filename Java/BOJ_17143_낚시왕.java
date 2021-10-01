package com.ssafy.day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17143 {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int fisher = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Shark> map[][] = new ArrayList[R][C];
		ArrayList<Shark> sharks = new ArrayList();
		int targetX = Integer.MAX_VALUE;
		int targetShark = Integer.MAX_VALUE;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = new ArrayList<Shark>();
			}
		}

		for (int i = 0; i < M; i++) {
			// 상어 정보들 받아주기
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			sharks.add(new Shark(r, c, s, d, z));
			if (c == fisher && r < targetX) {
				targetX = r;
				targetShark = i;
			}
		}
		int cnt = 0;
		int sum = 0;
		while (cnt < C) {
			// 사냥감이 있으면 잡아버리기
			if (targetShark != Integer.MAX_VALUE) {
				sum += sharks.get(targetShark).z;
				sharks.remove(targetShark);
			}
			// 상어 이동시키고 map으로 보내기
			for (int s = 0; s < sharks.size(); s++) {
				Shark curShark = sharks.get(s);
				// System.out.println("원래값r:"+curShark.r);
				// System.out.println("원래값c:"+curShark.c);
				int nr = curShark.r + curShark.s * dx[curShark.d];
				int nd = curShark.d;
				while (nr < 0 || nr >= R) {
					if (nr < 0) {
						nr = Math.abs(nr);
						nd = nd + 1;
					} else if (nr >= R) {
						nr = (R - 1) - (nr - (R - 1));
						nd = nd - 1;
					}
				}
				int nc = curShark.c + curShark.s * dy[curShark.d];
				while (nc < 0 || nc >= C) {
					if (nc < 0) {
						nc = Math.abs(nc);
						nd = nd - 1;
					} else if (nc >= C) {
						nc = (C - 1) - (nc - (C - 1));
						nd = nd + 1;
					}
				}
				// System.out.println("nr:"+nr);
				// System.out.println("nc:"+nc);
				// System.out.println("=============");
				map[nr][nc].add(new Shark(nr, nc, curShark.s, nd, curShark.z));
			}
			sharks.clear();
			fisher++;
			targetX = Integer.MAX_VALUE;
			targetShark = Integer.MAX_VALUE;
			int scnt = 0;
			// map확인해서 겹치면 한애 제거
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c].size() >= 2) {
						// 겹치는 상어중 작은쪽 죽음
						int max = 0;
						int maxsize = Integer.MIN_VALUE;
						for (int d = 0; d < map[r][c].size(); d++) {
							if (map[r][c].get(d).z > maxsize) {
								maxsize = map[r][c].get(d).z;
								max = d;
							}
						}
						Shark ss = map[r][c].get(max);
						sharks.add(new Shark(ss.r, ss.c, ss.s, ss.d, ss.z));
						map[r][c].clear();

						if (fisher == c && r < targetX) {
							targetShark = scnt;
							targetX = r;
						}
						scnt++;
					} else if (map[r][c].size() == 1) {
						Shark ss = map[r][c].get(0);
						map[r][c].clear();
						sharks.add(new Shark(ss.r, ss.c, ss.s, ss.d, ss.z));
						if (fisher == c && r < targetX) {
							targetShark = scnt;
							targetX = r;
						}
						scnt++;
					}
				}
			}
			cnt++;
		}
		System.out.println(sum);
	}

	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

}
