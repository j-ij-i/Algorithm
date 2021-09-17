import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
	static class Node{
		int x;
		int y;
		
		public Node() {
			super();
		}
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static List<Node> emptylist;
	static List<Node> viruslist;
	static int X,Y,Max;
	static boolean visited[];
	static int[] selected;
	static int[] dx= {0, 0 , -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map1, map2;
	static Queue<Node> q ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		emptylist = new LinkedList();
		viruslist = new LinkedList();

		st= new StringTokenizer (br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map1 = new int[X][Y];
		map2 = new int[X][Y];
		q = new LinkedList<>();
		for(int x = 0 ; x < X ; x++) {
			st= new StringTokenizer (br.readLine());
			for(int y = 0 ; y < Y ; y++) {
				int n = Integer.parseInt(st.nextToken());
				map1[x][y] = n;
				if(n == 0) {
					emptylist.add(new Node(x,y));
				}
			}
		}
		Max = Integer.MIN_VALUE;
		visited = new boolean[emptylist.size()];
		selected = new int[3];
		search(0);
		System.out.println(Max);
	}
	public static void search(int cnt) {
		if(cnt == 3) {
			copy();
			for(int j = 0 ; j< 3 ; j++) {
				Node nd = emptylist.get(selected[j]-1);
				map2[nd.x][nd.y] = 1;
			}
			while(!q.isEmpty()) {
				Node node = q.poll();
				for(int d = 0 ; d< 4 ; d++) {
					int nx = node.x+dx[d];
					int ny = node.y+dy[d];
					if(nx>= 0 && ny >= 0 && nx <X && ny <Y && map2[nx][ny] == 0) {
						map2[nx][ny] = 2;
						q.add(new Node(nx,ny));
					}
				}
			}
			int count = 0;
			for(int x= 0 ; x< X ; x++) {
				for(int y = 0 ; y < Y ;y++) {
					if(map2[x][y]==0)
						count++;
				}
			}
			Max = Math.max(count, Max);
			return;
		}
		for(int i=0; i<emptylist.size(); ++i) {
			if(!visited[i]){	
				visited[i] = true;
				selected[cnt] = i+1;
				search(cnt+1);			
				visited[i] = false;
			}
		}
	}
	public static void copy() {
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				map2[i][j] = map1[i][j];
				if (map2[i][j] == 2)
					q.offer(new Node(i, j));
			}
		}
	}
}
