import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1873 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Tank tank = new Tank();
		int dx[] = {-1,0,1,0};
		int dy[] = {0,-1,0,1};
		int T = sc.nextInt();
		for(int i = 0 ; i <T ; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char map[][] = new char[H][W];
			for(int h = 0 ; h< H ; h++) {
				String s = sc.next();
				for(int w = 0 ; w < W ; w++) {
					map[h][w] = s.charAt(w);
					if(map[h][w]== '<' ) {
						tank.y = h;
						tank.x = w;
						tank.dir = 0;
					}else if(map[h][w]=='^'){
						tank.y = h;
						tank.x = w;	
						tank.dir = 1;
					}else if(map[h][w]== '>') {
						tank.y = h;
						tank.x = w;
						tank.dir = 2;
					}else if( map[h][w]== 'v') {
						tank.y = h;
						tank.x = w;
						tank.dir = 3;
					}
				}
			}
			int moveCount = sc.nextInt();
			char move[] = new char[moveCount];
			String line = sc.next();
			move = line.toCharArray();
			for(int m = 0 ; m<move.length;m++) {

				if(move[m] == 'S') {
					int nx = tank.x;
					int ny = tank.y;
					nx = nx + dx[tank.dir];
					ny = ny + dy[tank.dir];

					while(nx>=0 && ny>=0 && nx<W && ny<H) {
						if(map[ny][nx]=='#') break;
						else if(map[ny][nx]=='*'){
							map[ny][nx]='.';
							break;
						}
						nx = nx + dx[tank.dir];
						ny = ny + dy[tank.dir];
					}
				}else {
					if(move[m] == 'L') {
						tank.dir = 0;
						if(	tank.y+dy[tank.dir]>=0 &&
							tank.x+dx[tank.dir]>=0 &&
							tank.y+dy[tank.dir]<H &&
							tank.x+dx[tank.dir]<W &&
							map[tank.y+dy[tank.dir]][tank.x+dx[tank.dir]] == '.') {
								map[tank.y][tank.x] = '.';
								tank.x= tank.x+dx[tank.dir];
								tank.y= tank.y+dy[tank.dir];
								map[tank.y][tank.x] = '<';
						}else {
							map[tank.y][tank.x] = '<';
						}
					}else if(move[m] == 'U') {
						tank.dir = 1;
						if(	tank.y+dy[tank.dir]>=0 &&
							tank.x+dx[tank.dir]>=0 &&
							tank.y+dy[tank.dir]<H &&
							tank.x+dx[tank.dir]<W &&
							map[tank.y+dy[tank.dir]][tank.x+dx[tank.dir]] == '.') {
								map[tank.y][tank.x] = '.';
								tank.x = tank.x +dx[tank.dir];
								tank.y = tank.y +dy[tank.dir];
								map[tank.y][tank.x] = '^';
						}else {
							map[tank.y][tank.x] = '^';
						}
					}else if(move[m] == 'R') {
						tank.dir = 2;
						if(	tank.y+dy[tank.dir]>=0 &&
							tank.x+dx[tank.dir]>=0 &&
							tank.y+dy[tank.dir]<H &&
							tank.x+dx[tank.dir]<W &&
							map[tank.y+dy[tank.dir]][tank.x+dx[tank.dir]] == '.') {
								map[tank.y][tank.x] = '.';
								tank.x = tank.x +dx[tank.dir];
								tank.y = tank.y +dy[tank.dir];
								map[tank.y][tank.x] = '>';
						}else {
							map[tank.y][tank.x] = '>';
						}
					}else if(move[m] == 'D') {
						map[tank.y][tank.x] = 'v';
						tank.dir = 3;
					if(	tank.y+dy[tank.dir]>=0 &&
						tank.x+dx[tank.dir]>=0 &&
						tank.y+dy[tank.dir]<H &&
						tank.x+dx[tank.dir]<W &&
					map[tank.y+dy[tank.dir]][tank.x+dx[tank.dir]] == '.') {
						map[tank.y][tank.x] = '.';
						tank.x= tank.x +dx[tank.dir];
						tank.y= tank.y+dy[tank.dir];
						map[tank.y][tank.x] = 'v';
					}
					}

				}

			}
			sb.append("#").append(i+1).append(" ");
			//System.out.print("#"+()+" ");
			for(int h = 0; h<H ; h++) {
				for(int w = 0 ; w<W ; w++) {
					sb.append(map[h][w]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		}
}

class Tank{
	int x;
	int y;
	int dir;
	
	public Tank() {
		super();
	}

	public Tank(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	@Override
	public String toString() {
		return "Tank [x=" + x + ", y=" + y + ", dir=" + dir + "]";
	}
}