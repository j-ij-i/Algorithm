import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N,result;
	static int map[][];
	static int people[];
	static boolean visited[];
	static ArrayList<Integer> areaA;
	static ArrayList<Integer> areaB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());		
		map = new int[N][N];
		people = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < N ; i++) {
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < num ; j++) {
				int cnt = Integer.parseInt(st.nextToken());
				map[i][cnt-1] = 1;
			}
		}
		visited = new boolean[N];
		result = Integer.MAX_VALUE;
		comb(0);
		if(result != Integer.MAX_VALUE)System.out.println(result);
		else if(result == Integer.MAX_VALUE)System.out.println("-1");
	}
	private static void comb(int cnt) {
		if(cnt == N) {
			areaA = new ArrayList<>();
			areaB = new ArrayList<>();
			for(int i = 0 ; i < N ; ++i) {
				if(visited[i])
					areaA.add(i);
				else
					areaB.add(i);
			}
			if(bfs(areaA)&& bfs(areaB)) {
				int aA = 0;
				int aB = 0;
				for(int l : areaA) {
					aA+= people[l];
				}
				for(int l : areaB) {
					aB+= people[l];
				}
				result = Math.min(result, Math.abs(aA - aB));
			}
			return;
		}
		visited[cnt] = true;
		comb(cnt+1);
		visited[cnt] = false;
		comb(cnt+1);
	}
	
	private static boolean bfs(ArrayList<Integer> area) {
		if(area.size() == 0) return true;
		
		boolean isVisited[] = new boolean[N];
		for(int i = 0 ; i < N ; i++) {
			isVisited[i] = true;
		}
		for(int l : area) {
			isVisited[l] = false;
		}
		int totalCnt = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(area.get(0));
		totalCnt++;
		isVisited[area.get(0)] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int j = 0; j < N ;j++) {
				if(map[x][j] == 1 && !isVisited[j]) {
					totalCnt++;
					isVisited[j] = true;
					q.add(j);
				}
			}
		}
		if(totalCnt == area.size()) {
			return true;
		}else {
			return false;
		}
	}
}
