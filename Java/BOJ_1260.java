import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ_1260 {
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
	}
	static int N, M,V;
	static Node[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adjList = new Node[M+1];
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		bfs();
		boolean[] visited = new boolean[N+1];
		dfs(0, visited);
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		queue.offer(V);
		visited[V] = true;

		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current + 65));
			
			for(Node temp = adjList[current]; temp != null ; temp = temp.link) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
	
	private static void dfs(int current, boolean[] visited) {//

		visited[current] = true;
		System.out.println((char)(current + 65));
		
			for(Node temp = adjList[current]; temp != null ; temp = temp.link) {
				if(!visited[temp.vertex]) {
					dfs(temp.vertex, visited);
				}
		}
	}

}
