import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2887 {

	static class Planet {
		int n;
		int x;
		int y;
		int z;

		Planet(int n, int x, int y, int z) {
			this.n = n;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}

	}

	private static void make() {
		parent = new int[N];
		for(int i = 0 ; i < N ; i++) {
			parent[i] = i;
		}
	}
	
	static int[] parent;
	static ArrayList<Edge> edgeList;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		Planet[] planet = new Planet[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planet[i] = new Planet(i, x, y, z);
		}

		edgeList = new ArrayList<>();
		
		Arrays.sort(planet, (p1, p2) -> p1.x - p2.x);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(planet[i].x - planet[i + 1].x);
			edgeList.add(new Edge(planet[i].n, planet[i + 1].n, weight));
		}

		Arrays.sort(planet, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(planet[i].y - planet[i + 1].y);
			edgeList.add(new Edge(planet[i].n, planet[i + 1].n, weight));
		}

		Arrays.sort(planet, (p1, p2) -> p1.z - p2.z);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(planet[i].z - planet[i + 1].z);
			edgeList.add(new Edge(planet[i].n, planet[i + 1].n, weight));
		}
		
		make();

		Collections.sort(edgeList);

		int result = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			if (find(edge.start) != find(edge.end)) {
				result += edge.weight;
				union(edge.start, edge.end);
			}
		}
		System.out.println(result);
	}

}
