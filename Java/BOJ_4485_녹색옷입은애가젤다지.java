import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int map[][];
    static int dist[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = 0;
        
        while (true) {
        	tc++;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            map = new int[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }
            sb.append("Problem ").append(tc).append(": ").append(bfs(new Node(0, 0, map[0][0]), N)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int bfs(Node node, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(node);

        dist[node.x][node.y] = map[node.x][node.y];
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (dist[n.x][n.y] < n.rupee) continue;
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (dist[nx][ny] > dist[n.x][n.y] + map[nx][ny]) {
                    dist[nx][ny] = dist[n.x][n.y] + map[nx][ny];
                    pq.add(new Node(nx, ny, dist[nx][ny]));
                }
            }
        }
        return dist[N - 1][N - 1];
    }
}
class Node implements Comparable<Node> {
    int x, y;
    int rupee;

    Node(int x, int y, int rupee) {
        this.x = x;
        this.y = y;
        this.rupee = rupee;
    }

    @Override
    public int compareTo(Node o) {
        return this.rupee - o.rupee;
    }
}