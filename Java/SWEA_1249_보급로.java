import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA_1249_보급로 {
	static int N;
	static int map[][];
	static int dist[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static StringBuilder sb;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= T ; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			for(int x = 0 ; x < N; x++) {
				String str = br.readLine();
				for(int y = 0; y < N ; y++) {
					map[x][y] = str.charAt(y)-'0';
					dist[x][y] = INF;
				}
			}
			bfs();
			sb.append("#").append(i).append(" ").append(dist[N-1][N-1]).append("\n");
		}
		System.out.println(sb.toString());

	}
	private static void bfs() {
		PriorityQueue<Node>q = new PriorityQueue<>();
		q.add(new Node(0,0,map[0][0]));
		dist[0][0] = map[0][0];
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(dist[n.x][n.y] < n.time) continue;
			for(int d = 0 ; d < 4 ; d++) {
				int nx = dx[d] + n.x;
				int ny = dy[d] + n.y;
				if(isArea(nx,ny)) {
					if(dist[nx][ny] > dist[n.x][n.y] + map[nx][ny]) {
						dist[nx][ny] = dist[n.x][n.y]+ map[nx][ny];
						q.add(new Node(nx,ny,dist[nx][ny]));
					}
				}
			}
		}
	}
	
    private static boolean isArea(int nx, int ny) {
		if(nx >= 0 && ny >= 0 && nx < N && ny < N ) return true;
		return false;
	}

	static class Node implements Comparable<Node>{
    	int x;
    	int y;
    	int time;
		public Node(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	    @Override
	    public int compareTo(Node o) {
	        return this.time - o.time;
	    }
    }

}
