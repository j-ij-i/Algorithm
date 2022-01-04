import java.io.*;
import java.util.*;

public class BOJ_14502_re {
	static int number[];
	static int N, M, MAX, R, zero;
	static int arr[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static List<int[]> emptylist, virus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		emptylist = new ArrayList<>();
		virus = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		zero = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = 3;
		arr = new int[N][M];
		MAX = Integer.MIN_VALUE;
		number = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					zero++;
					emptylist.add(new int[] { i, j });
				} else if (arr[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
		comb(0, 0);
		System.out.println(MAX);
	}

	private static void comb(int cnt, int start) {
		// TODO Auto-generated method stub
		if(R == cnt) {
			int newarr[][] = deepCopyWithClone(arr);
			for(int x = 0 ; x < 3 ; x++) {
				int select[] = emptylist.get(number[x]);
				newarr[select[0]][select[1]] = 1;
			}
			bfs(newarr);
			return;
		}
		for(int i = start ; i < zero ; ++i) {
			number[cnt] = i;
			comb(cnt+1, i+1);
		}
	}

	private static int[][] deepCopyWithClone(int[][] newarr) {
		// TODO Auto-generated method stub
		if(newarr == null) return null;
		int[][] resultarr = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				resultarr[i][j] = newarr[i][j];
			}
		}
		return resultarr;
	}

	private static void bfs(int narr[][]) {
		Queue<int[]> queue = new LinkedList<>(); 
		int safeArea = 0;
		//
		//바이러스 퍼트리기
		for(int i = 0 ; i < virus.size() ; i++) {
			int virusarea[] = virus.get(i);
			queue.add(virusarea);
			while(!queue.isEmpty()) {
				int loca[] = queue.poll();
				for(int d = 0 ; d<4 ; d++) {
					int nx = loca[0] + dx[d];
					int ny = loca[1] + dy[d];
					if(isArea(nx,ny) && narr[nx][ny] == 0) {
						//0이면 큐넣어주고 바이러스도 퍼트리기
						narr[nx][ny] = 2;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
		
		//0 갯수 세기 (한번 처음 초기값에서 계산하는것도 해보깅)
		for(int i = 0 ; i < N;i++) {
			for(int j = 0 ; j < M ; j++) {
				if(narr[i][j] == 0) {
					safeArea++;
				}
			}
		}
		
		//안전지대가 최대값이면 갱신
		MAX = Math.max(MAX, safeArea);
		
	}

	private static boolean isArea(int nx, int ny) {
		// TODO Auto-generated method stub
		if(nx>= 0 && ny >= 0 && nx < N && ny < M) return true;
		return false;
	}
}
