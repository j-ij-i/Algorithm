import java.util.Scanner;
//set을 사용하면 좋음!! 중복이 안됨!
public class SWEA_1974 {
	static int arr[][];
	static int flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for(int i = 1 ; i <= T ; i++){
			flag = 1;
			arr = new int [10][10];
			for(int x = 1 ; x <= 9 ; x ++) {
				for(int y =1 ; y <= 9 ; y++)
					arr[x][y] = sc.nextInt();
			}
			//세로줄 체크
			for(int x = 1 ; x <= 9 ; x ++) {
				int numCheck[] = new int [10];
				for(int y =1 ; y <= 9 ; y++)
					if(numCheck[arr[x][y]] != 1) {
						numCheck[arr[x][y]] = 1;
					}else {
						flag = 0;
						break;
					}
			}
			
			//가로줄 체크
			for(int x = 1 ; x <= 9 ; x ++) {
				int numCheck[] = new int [10];
				for(int y =1 ; y <= 9 ; y++)
					if(numCheck[arr[y][x]] != 1) {
						numCheck[arr[y][x]] = 1;
					}else {
						flag = 0;
						break;
					}
			}
			//정사각형 체크
			Square(1,1);
			sb.append("#").append(i).append(" ").append(flag).append("\n");
		}
		System.out.println(sb.toString());

	}
	static void Square(int x, int y) {
		if(x<9 && y<9) {
			int numCheck[] = new int [10];
			for(int xx = x ; xx <= x+2 ; xx++) {
				for(int yy = y ; yy <= y+2 ; yy++) {
					if(numCheck[arr[xx][yy]] != 1) {
						numCheck[arr[xx][yy]] = 1;
					}else {
						flag = 0;
						return;
					}
				}
			}
		}else return;
		
		Square(x+3, y);
		Square(x, y+3);
	}

}
