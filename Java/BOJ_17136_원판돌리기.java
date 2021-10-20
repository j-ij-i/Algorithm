package algo_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//01:46:37
//https://www.acmicpc.net/problem/17822
public class BOJ_17822 {
	static int arr[][];
	static int dn[] = { 0, 0, 1, -1 };
	static int dm[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int t = 1; t <= T; t++) {
//			System.out.println("T: "+t);
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			for (int b = x; b <= N;) {
				if (dir == 0) { // 시계 방향
					int temp = 0;
					for (int n = 0; n < num; n++) {
						for (int a = M; a > 0; a--) {
							if(a == M) {
								temp = arr[b][a];
							}
							if(a == 1) {
								arr[b][a] = temp;
							}else {
								arr[b][a] = arr[b][a-1];
							}
						}
					}
				} else if (dir == 1) { // 반시계 방향
					int temp = 0;
					for (int n = 0; n < num; n++) {
						for (int a = 1; a <= M; a++) {
							if (a == 1) {
								temp = arr[b][a];
							}
							if (a == M) {
								arr[b][a] = temp;
							} else {
								arr[b][a] = arr[b][a + 1];
							}
						}
					}

				}
				b = b + x;
			}
//			System.out.println("=================소거전===========");
//			for (int z = 1; z <= N; z++) {
//				for (int y = 1; y <= M; y++) {
//					System.out.print(arr[z][y]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("=================================");
			
			// 같은거 찾아주는 부분
			boolean flag[][] = new boolean[N + 1][M + 1];
			boolean mainflag = false;
			int sum = 0;
			int totalCnt = 0;
			for (int z = 1; z <= N; z++) {
				for (int y = 1; y <= M; y++) {
					if (arr[z][y] != 0) {
						sum += arr[z][y];
						totalCnt++;
					}
					for (int d = 0; d < 4; d++) {
						int nn = z + dn[d];
						int nm = y + dm[d];

						if (nn == 0)
							continue;
						else if (nn > N)
							continue;

						if (nm == 0)
							nm = M;
						else if (nm > M)
							nm = 1;
						
						if (arr[nn][nm] == arr[z][y] && arr[z][y]!=0) {
//							System.out.println("왜..? nn:"+nn +" nm:"+nm +" z:"+z+" y:"+y);
//							System.out.println(d);
							flag[nn][nm] = true;
							flag[z][y] = true;
							mainflag = true;
						}
					}
				}
			}
//			System.out.println(mainflag);
			if (mainflag == true) {
				for (int z = 1; z <= N; z++) {
					for (int y = 1; y <= M; y++) {
						if (flag[z][y] == true) {
							arr[z][y] = 0;
						}
					}
				}
			} else {
//				System.out.println("실행~~~");
				double avg = (double)((double)sum / (double)totalCnt);
//				System.out.println(avg);
				for (int z = 1; z <= N; z++) {
					for (int y = 1; y <= M; y++) {
						if(arr[z][y] == 0) {
							continue;
						}
						else if ((double)arr[z][y] > avg) {
							arr[z][y] -= 1;
						} else if ((double)arr[z][y] < avg) {
							arr[z][y] += 1;
						}
					}
				}
			}
//			System.out.println("=================소거후===========");
//			for (int z = 1; z <= N; z++) {
//				for (int y = 1; y <= M; y++) {
//					System.out.print(arr[z][y]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("=================================");
		}
		int result = 0;
//		System.out.println("최종!!!");
		for (int z = 1; z <= N; z++) {
			for (int y = 1; y <= M; y++) {
				result += arr[z][y];
		//		System.out.print(arr[z][y]+" ");
			}
//			System.out.println();
		}
		System.out.println(result);
	}

}
