import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_16935 {
	static int arr[][] ; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		arr = new int[N+1][M+1];
		for(int x = 1; x<=N ; x++) {
			for(int y=1 ; y<=M ; y++) {
				arr[x][y] = sc.nextInt();
			}
		}		
		sc.nextLine();
		String commandLine = sc.nextLine();;
		StringTokenizer st = new StringTokenizer(commandLine);
		for(int i = 1; i <= R ; i++) {
			int cmd = Integer.parseInt(st.nextToken());
		switch(cmd) {
		case 1:
			Rotate1(1,1,N,M);
			break;
		case 2:
			Rotate2(1,1,N,M);
			break;
		case 3:
			Rotate3(1,1,N,M);
			int temp1 = N;
			N = M;
			M = temp1;
			break;
		case 4:
			Rotate4(1,1,N,M);
			int temp2 = N;
			N = M;
			M = temp2;
			break;
		case 5:
			Rotate5(1,1,N,M);
			break;
		case 6:
			Rotate6(1,1,N,M);
			break;
		}
		}
		for(int x = 1; x<=(arr.length-1) ; x++) {
			for(int y=1 ; y<=(arr[0].length-1) ; y++) {
				System.out.print(arr[x][y]+" ");
			}
			System.out.println(); 
		}
	}
	
	static void Rotate1(int minX, int minY, int maxX , int maxY) {
		while(true) {
			for(int i =1 ; i <=maxY ; i++) {
				int temp = arr[minX][i];
				arr[minX][i] = arr[maxX][i];
				arr[maxX][i] = temp;
			}
			if(maxX - minX <= 1)
				break;
			else {
				minX +=1;
				maxX -=1;
			}
		}
	}
	
	static void Rotate2(int minX, int minY, int maxX , int maxY) {
		while(true) {
			for(int i = 1 ; i <=maxX ; i++) {
				int temp = arr[i][minY];
				arr[i][minY] = arr[i][maxY];
				arr[i][maxY] = temp;
			}
			if(maxY - minY <= 1)
				break;
			else {
				minY +=1;
				maxY -=1;
			}
		}
	}
	
	static void Rotate3(int minX, int minY, int maxX , int maxY) {
		int arr_clone [][] = new int [maxY+1][maxX+1];
		for(int x = 1; x <= maxY ; x++) {
			int mX = maxX;
			for(int y = 1; y <= maxX ; y++) {
				arr_clone[x][y] = arr[mX][x];
				mX -=1;
			}
		}
		arr = arr_clone.clone();
	}
	
	static void Rotate4(int minX, int minY, int maxX , int maxY) {
		int arr_clone [][] = new int [maxY+1][maxX+1];
		int mY = maxY;
		for(int x = 1; x <= maxY ; x++) {
			for(int y = 1; y <= maxX ; y++) {
				arr_clone[x][y] = arr[y][mY];	
			}
			mY -=1;
		}
		arr = arr_clone.clone();
	}
	
	static void Rotate5(int minX, int minY, int maxX , int maxY) {
		int halfX = maxX/2;
		int halfY = maxY/2;
		for(int x = 1; x<=halfX ; x++) {
			for(int y = 1; y<=halfY ; y++) {
				int temp = arr[x][y];
				arr[x][y] = arr[x+halfX][y];
				 arr[x+halfX][y]= arr[x+halfX][y+halfY];
				arr[x+halfX][y+halfY] = arr[x][y+halfY];
				arr[x][y+halfY] = temp;
			}
		}
	}
	
	static void Rotate6(int minX, int minY, int maxX , int maxY) {
		int halfX = maxX/2;
		int halfY = maxY/2;
		for(int x = 1; x<=halfX ; x++) {
			for(int y = 1; y<=halfY ; y++) {
				int temp = arr[x][y];
				arr[x][y] = arr[x][y+halfY];
				arr[x][y+halfY]= arr[x+halfX][y+halfY];
				arr[x+halfX][y+halfY] = arr[x+halfX][y];
				arr[x+halfX][y] = temp;
			}
		}
	}
	

}
