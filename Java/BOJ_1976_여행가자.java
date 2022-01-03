import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
	static int map[][];
	static int totalCnt,M,N;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			list.add(Integer.parseInt(st.nextToken())-1);
		}
		
		boolean flag = true;
		for(int i = 0;  i< M-1 ; i++) {
			if(!bfs(list.get(i), list.get(i+1))) {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	private static boolean bfs(int start, int goal) {
		boolean visited[] = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.add(start);
		while(!q.isEmpty()) {
			int n = q.poll();
			if(n == goal) {
				return true;
			}
			for(int i = 0 ; i < N ; i++) {
				if(map[n][i] == 1 && visited[i] == false) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		return false;
	}
}
