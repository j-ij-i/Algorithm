import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JOL_1681_해밀턴순환회로_fail {
	static int map[][];
	static int N;
	static int[] input, selected;
	static boolean[] flag;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
	      for(int x = 0 ; x < N ; x++) {
	          st = new StringTokenizer(br.readLine());
	          for(int y = 0; y < N ; y++) {
	             map[x][y] = Integer.parseInt(st.nextToken());
	          }
	       }
		min = Integer.MAX_VALUE;
		flag = new boolean[N];
		selected = new int[N-1];
		permu(0);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
		}else System.out.println(min);
	}
	private static void permu(int cnt) {
		if(cnt == N-1) {
			int count = 0;
			if(map[0][selected[0]] == 0) {
				return;
			}
			count += map[0][selected[0]];
			for(int i = 0; i < N-2; i++) {
				if(map[selected[i]][selected[i+1]] == 0) {
					return;
				}
				count += map[selected[i]][selected[i+1]]; 
			}
			if(map[selected[N-2]][0] == 0) {
				return;
			}
			count += map[selected[N-2]][0];
			min = Math.min(min, count);
			return;
		}
		
		for(int i=1; i<N; ++i) {
			if(!flag[i]){ //사용 안했음		
				flag[i] = true;
				selected[cnt] = i; //cnt 위치에 i값 저장
				permu(cnt+1);//다음 위치에 넣을 값 뽑으러 보냄				
				flag[i] = false;
			}
		}
	}
}
