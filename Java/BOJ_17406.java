import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_17406 {
	static int[][] arr;
	static int N, M, R;
	static int N_MAX, R_MAX;
	static int MaxX, MaxY, minX, minY;
	static int[] numbers;
	static boolean[] isSelected;
	static String order[];
	static int minArr = Integer.MAX_VALUE;
	static int[][] arr_clone;
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		order = new String[R+1];
		
		numbers = new int[R];
		isSelected = new boolean[R+1];
		
		arr = new int[N+1][M+1];
		for(int x = 1 ; x<=N ; x++) {
			for(int y = 1; y<=M ; y++) {
				arr[x][y] = sc.nextInt();
			}
		}
		sc.nextLine();
		for (int i = 1; i <= R; i++) {
			order[i] = sc.nextLine();
		}
		permutation(0);
		System.out.print(minArr);
	}
	
	static void rightRotate(int minX, int minY, int maxX , int maxY) {
		int temp = arr_clone[minX][maxY];
		for(int i=maxY-1; i>=minY; i--) arr_clone[minX][i+1] = arr_clone[minX][i];
		for(int i=minX+1; i<=maxX; i++) arr_clone[i-1][minY] = arr_clone[i][minY];
		for(int i=minY+1; i<=maxY; i++) arr_clone[maxX][i-1] = arr_clone[maxX][i];
		for(int i=maxX-1; i>minX; i--) arr_clone[i+1][maxY] = arr_clone[i][maxY];
		arr_clone[minX+1][maxY] = temp;
	}
	
	private static void permutation(int cnt) {
			if(cnt == R ) {
//				System.out.println("---------------------------");
				arr_clone = new int [N+1][M+1];
				for(int x = 1 ; x<=N ; x++) {
					for(int y = 1; y<=M ; y++) {
						arr_clone[x][y] = arr[x][y];
					}
				}
				for(int i = 0 ; i<numbers.length; i++) {				
					System.out.println(order[numbers[i]]);
					String str = order[numbers[i]];
					StringTokenizer st = new StringTokenizer(str);
					int r = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					int s = Integer.parseInt(st.nextToken());
					MaxX = r+s;
					MaxY = c+s;
					minX = r-s;
					minY = c-s;
					
					Boolean flag = true;
					while(flag==true) {
						if( MaxX-minX <= 0|| MaxY-minY <= 0) break;
						else {
							rightRotate(minX,minY, MaxX, MaxY);
							minX+=1;
							minY+=1;
							MaxX-=1;
							MaxY-=1;
						}
					}
				}
				for(int x = 1 ; x<=N ; x++) {
					minArr = Math.min(IntStream.of(arr_clone[x]).sum(), minArr);
				}
				return;
			}
			
			for(int i = 1; i <= R ; i++) {
				if(isSelected[i]) continue;
				numbers[cnt] = i;
				isSelected[i] = true;
				permutation(cnt+1);
				isSelected[i] = false;
			}
		}
}
