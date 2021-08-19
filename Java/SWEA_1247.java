import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1247 {
	static int minDt, N, Dt;
	static Start start;
	static End end;
	static Guest gst[];
	static boolean visited[];
	static int[] numbers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <= T ; i++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			start = new Start(startx, starty);
			
			int endx = Integer.parseInt(st.nextToken());
			int endy = Integer.parseInt(st.nextToken());
			end = new End(endx, endy);
			
			gst = new Guest[N];
			visited = new boolean[N];
			numbers = new int[N];
			for(int j = 0 ; j <N; j++ ) {
				int Gx = Integer.parseInt(st.nextToken());
				int Gy = Integer.parseInt(st.nextToken());
				gst[j] = new Guest(Gx, Gy);		
			}
			minDt = Integer.MAX_VALUE;
			permu(0);
			sb.append("#").append(i).append(" ").append(minDt).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void permu(int cnt) {
		if(cnt == N ) {
			Dt = 0;
			Calc( start.x, start.y , gst[numbers[0]].x, gst[numbers[0]].y);
			for(int d = 0; d <=N-2; d++) {
				Calc( gst[numbers[d]].x, gst[numbers[d]].y ,  gst[numbers[d+1]].x, gst[numbers[d+1]].y );
			}
			Calc( gst[numbers[N-1]].x, gst[numbers[N-1]].y , end.x, end.y );
			minDt = Math.min(Dt, minDt);
			return;
		}
		for(int i = 0; i < N ; i++) {
			if(visited[i]) continue;
			numbers[cnt] = i;
			visited[i] = true;
			
			permu(cnt+1);
			visited[i] = false;
		}
	}
	
	private static void Calc(int x, int y, int x2, int y2) {
		Dt += Math.abs(x-x2)+Math.abs(y-y2);
		return;
	}
}
class Guest{
	int x;
	int y;
	public Guest(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

class Start{
	int x;
	int y;
	public Start(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}


class End{
	int x;
	int y;
	public End(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

