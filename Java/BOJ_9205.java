import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= T ; i++) {
			int Gnum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			Start start= new Start(sx , sy);
			
			G c[] = new G[Gnum+1];
			for(int j = 0 ; j< Gnum ; j++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				c[j] = new G(cx, cy);
			}
			
			st = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(st.nextToken());
			int fy = Integer.parseInt(st.nextToken());
			c[Gnum] = new G(fx, fy);
			boolean visited[] = new boolean[Gnum+1];
			boolean flag = false;
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{start.x, start.y});
			while(!q.isEmpty()) {
				int location[] = q.poll();
				if( (Math.abs(location[0] - c[Gnum].x) + Math.abs(location[1] - c[Gnum].y)) <= 1000) {
					flag = true;
					break;
				}
				for(int a = 0 ; a <= Gnum ; a++) {	
					if(visited[a] == false && (Math.abs(location[0] - c[a].x) + Math.abs(location[1] - c[a].y)) <= 1000) {
						q.add(new int[] {c[a].x, c[a].y});
						visited[a] = true;
					}
				}				
			}
			if(flag == true) {
				sb.append("happy");
			}else {
				sb.append("sad");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

class G{
	int x;
	int y;
	public G(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "GS [x=" + x + ", y=" + y + "]";
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