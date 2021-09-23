import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class fireball {
	int r;
	int c;
	int m;
	int s;
	int d;

	public fireball(int r, int c, int m, int s, int d) {
		super();
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}

	@Override
	public String toString() {
		return "fireball [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
	}
}

public class BOJ_20056 {

	static int N, M, K;
	static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static ArrayList<fireball> map[][];
	static ArrayList<fireball> fball = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new ArrayList[N][N];
		// map을 초기화 시켜주지 않으면 NullPointerException이 발생한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<fireball>();
			}
		}

		// fball ArrayList에 파이어볼정보 하나씩 대입
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ri = Integer.parseInt(st.nextToken())- 1; // 1을 기준으로 넣어주기 때문에 -1인 상태로 넣어줘야함
			int ci = Integer.parseInt(st.nextToken())- 1;
			int mi = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			int di = Integer.parseInt(st.nextToken());
			fball.add(new fireball(ri, ci, mi, si, di));
		}

		// K번만큼 이동을 명령시킴
		for (int i = 0; i < K; i++) {
			// 각 파이어볼 이동
			for (int j = 0; j < fball.size(); j++) {
//				System.out.println(j);
				fireball f = fball.get(j);
				f.r = (f.r+ N+(dx[f.d] * (f.s % N))) % N; // 속력 s가 N을 넘게될 수 있으므로 N%를 계산
				f.c = (f.c+ N+(dy[f.d] * (f.s % N))) % N; // N을 더하는 이유는 파이어볼이 4개로 나누어질때 범위 밖으로 넘어갈 수 있으므로 N을 더해줘서 안전범위로?
//				System.out.println(f.c);
//				System.out.println(f.r);
				map[f.r][f.c].add(f);
			}
			// 파이어볼 판단
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (map[x][y].size() == 1) {
						map[x][y].clear();
					} else if (map[x][y].size() >= 2) {
						int nm = 0;
						int ns = 0;
						int dflag = (map[x][y].get(0).d % 2);
						boolean flag = true;
						for (fireball fb : map[x][y]) {
							nm += fb.m;
							ns += fb.s;
							if ((fb.d % 2) != dflag) {
								flag = false;
							}
							fball.remove(fb); // 몰랐던 부분!! 이런식으로 지울수있구나..
						}
						int size = map[x][y].size();
						map[x][y].clear();
						if ((nm / 5) > 0) {
							int a = 0;
							if (flag == true)
								a = 0;
							else
								a = 1;
							for (int t = a; t < 8;) {
								fball.add(new fireball(x, y, nm/5, ns/size, t));
//								System.out.println(flag == true ? "true" : "false");
								t += 2;
							}
						}

					}
				}
			}
		}

		int result = 0;
		for (fireball f : fball) {
			result += f.m;
		}
		System.out.println(result);
	}

}
