import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606 {
	public static int[] parent;
	public static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		make();
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			union(v1,v2);
		}
	       int cnt = 0;
	        for(int i = 2; i <= N; i++) {
	            if(find(i)== find(1))
	                ++cnt;
	        }
	        System.out.println(cnt);	
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
	      if(x > y) {
	            parent[x] = y;
	        } else {
	            parent[y] = x;
	        }
	}
	private static int find(int x) {
        if(x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
	private static void make() {
		for(int i = 1 ; i <= N ; i++) {
			parent[i] = i;
		}
	}

}
