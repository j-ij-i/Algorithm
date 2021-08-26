import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
    
	static int map[][];
	static int dist[][];
	static int N, mindist, shartEatCnt;
	static int minX;
    static int minY;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
	static Shark babysrk = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0 ;
	    N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					babysrk = new Shark(i,j,2);
				}
			}
		}
		while(true) {
            dist = new int[N + 1][N + 1];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            mindist = Integer.MAX_VALUE;
            bfs(babysrk.x, babysrk.y);
            
            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
            	shartEatCnt++;
            	map[babysrk.x][babysrk.y] = 0;
            	babysrk.x = minX;
            	babysrk.y = minY;
            	map[babysrk.x][babysrk.y] = 9;
            	result += dist[minX][minY];
            	
            	if(shartEatCnt == babysrk.size) {
            		babysrk.size += 1;
            		shartEatCnt = 0;
            	}
            	
            }else {
            	break;
            }
            break;
		}
		System.out.println(result);
	}
	
	private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (isInArea(newX, newY) && isAbleToMove(newX, newY) && dist[newX][newY] == 0) {
                    dist[newX][newY] = dist[p.x][p.y] + 1;
                    if (isEatable(newX, newY)) {
                        if (mindist > dist[newX][newY]) {
                            mindist = dist[newX][newY];
                            minX = newX;
                            minY = newY;
                        } else if (mindist == dist[newX][newY]) {
                            if (minX == newX) {
                                if (minY > newY) {
                                    minX = newX;
                                    minY = newY;
                                }
                            } else if (minX > newX) {
                                minX = newX;
                                minY = newY;
                            }
                        }
                    }
                    queue.add(new Point(newX, newY));
                }
            }
        }
    }

	private static boolean isAbleToMove(int x, int y) {
		return map[x][y] <= babysrk.size;
	}

	private static boolean isEatable(int x, int y) {
		return map[x][y] != 0 && map[x][y] < babysrk.size;
	}

	private static boolean isInArea(int x, int y) {
		return x <= N && x > 0 && y <= N && y > 0;
	}

	private static class Point {
		private int x;
		private int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
}


class Shark{
	int x;
	int y;
	int size;
	
	public Shark(int x, int y, int size) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
	}
}