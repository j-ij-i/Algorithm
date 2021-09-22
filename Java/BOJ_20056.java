import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class fireball{
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
	
	static int N,M,K;
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,1,1,1,0,-1,-1,-1};
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
			
		//fball ArrayList에 파이어볼정보 하나씩 대입
		for(int i =0 ; i <M ; i++) {
			st = new StringTokenizer(br.readLine());
			int ri = Integer.parseInt(st.nextToken());
			int ci = Integer.parseInt(st.nextToken());
			int mi = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			int di = Integer.parseInt(st.nextToken());
			fball.add(new fireball(ri,ci,mi,si,di));
		}
		
		//K번만큼 이동을 명령시킴
		for(int i = 0; i< K ; i++) {
			//각 파이어볼 이동
			for(int j = 0 ; j < fball.size(); j++) {
				fireball f = fball.get(j);
				f.r = (f.r + (dx[f.d] * (f.s % N)))%N; // 속력 s가 N을 넘게될 수 있으므로 N%를 계산한 후 
				f.c = (f.c + (dy[f.d] * (f.s % N)))%N;
				map[f.c][f.c].add(f);
			}
			// 파이어볼 판단
			for(int x = 0 ; x < N ; x++) {
				for(int y = 0 ; y < N ; y++) {
					if(map[x][y].size() == 1) {
						
					}else if(map[x][y].size() >= 2) {
						int nm = 0;
						int ns = 0;
						int dflag = (map[x][y].get(0).d % 2);
						boolean flag = true;
						for(fireball fb : map[x][y]) {
							nm += fb.m;
							ns += fb.s;
							if((fb.d % 2) != dflag) {
								flag = false;
							}
							fball.remove(fb); //몰랐던 부분!! 이런식으로 지울수있구나..
						}
						
						if((nm / 5) > 0) {
							int a = 0;
							if(flag == true)
								a = 0;
							else
								a = 1;
							
							for(int t = a ; t < 8;) {
								fball.add(new fireball(x+dx[t],y+dy[t],1,nm/5, ns/map[x][y].size()));
								t += 2;
							}
							map[x][y].clear();
						}
						
					}
				}
			}
		}
		
		int result = 0 ;
		for(fireball f : fball) {
			result += f.m;
		}
		System.out.println(result);
	}

}
