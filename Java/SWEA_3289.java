
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {
	static int[] parents;

	private static void make(int N) {
		for(int i = 1 ; i < N+1 ; i++) {
			parents[i] = i;
		}
	}
	private static int find (int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	private static int decideuni(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return 1;
		return 0;
	}
	
	private static void makeuni(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return;

		parents[bRoot] = aRoot;
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <=T ; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		
			parents = new int[N+1];
			make(N);
			sb.append("#").append(t).append(" ");
			for(int i = 1 ; i <= M ; i++) {
				st = new StringTokenizer(br.readLine());
				int flag = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(flag) {
				case 0:
					makeuni(a,b);
					break;
				case 1:
					sb.append(decideuni(a,b));
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
