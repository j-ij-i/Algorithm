import java.io.*;
import java.util.*;

public class BOJ_1707 {
	static int V, E;
	static ArrayList<Integer>[] graph;
	static int colors[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			colors = new int[V+1];
			graph = new ArrayList[V+1]; 
			for(int i = 0; i <= V; i++)
				graph[i] = new ArrayList<Integer>();

			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				graph[p1].add(p2);
				graph[p2].add(p1);
			}
			bfs();
		}
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();

		for(int i = 1; i <= V; i++) {
			if(colors[i] == 0) {
				q.add(i);
				colors[i] = 1;
			}

			while(!q.isEmpty()) {
				int cur = q.poll();

				for(int j = 0; j < graph[cur].size(); j++) {
					if(colors[graph[cur].get(j)] == 0) {
						q.add(graph[cur].get(j));
					}
					
					if(colors[graph[cur].get(j)] == colors[cur]) {
						System.out.println("NO");
						return;
					}

					if(colors[cur] == 1 && colors[graph[cur].get(j)] == 0)
						colors[graph[cur].get(j)] = 2;
					else if(colors[cur] == 2 && colors[graph[cur].get(j)] == 0)
						colors[graph[cur].get(j)] = 1;
				}
			}
		}

		System.out.println("YES");
	}

}