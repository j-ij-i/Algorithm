import java.io.IOException;
import java.util.Scanner;

public class BOJ_16926 {
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int MaxX = N;
		int MaxY = M;
		int min = 1;
		arr = new int[N+1][M+1];
		for(int x = 1 ; x<=N ; x++) {
			for(int y = 1; y<=M ; y++) {
				arr[x][y] = sc.nextInt();
			}
		}
		for(int i = 1 ; i <= R ; i++){
			Boolean flag = true;
			MaxX = N;
			MaxY = M;
			min = 1;
			while(flag==true) {
				rightRotate(min, MaxX, MaxY);
				min+=1;
				MaxX-=1;
				MaxY-=1;
			if( MaxX-min <1|| MaxY-min <1) flag=false;
			}
		}
		
		for(int x = 1 ; x<=N ; x++) {
			for(int y = 1; y<=M ; y++) {
				sb.append(arr[x][y]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void leftRotate(int min , int maxX , int maxY) {
		int temp = arr[min][min];
		for(int i=min+1; i<=maxY; i++) arr[min][i-1] = arr[min][i];
		for(int i=min+1; i<=maxX; i++) arr[i-1][maxY] = arr[i][maxY];
		for(int i=maxY-1; i>=min; i--) arr[maxX][i+1] = arr[maxX][i];
		for(int i=maxX-1; i>min; i--) arr[i+1][min] = arr[i][min];
		arr[min+1][min] = temp;
	}
	
	static void rightRotate(int min , int maxX , int maxY) {
		int temp = arr[min][maxY];
		for(int i=maxY-1; i>=min; i--) arr[min][i+1] = arr[min][i];
		for(int i=min+1; i<=maxX; i++) arr[i-1][min] = arr[i][min];
		for(int i=min+1; i<=maxY; i++) arr[maxX][i-1] = arr[maxX][i];
		for(int i=maxX-1; i>min; i--) arr[i+1][maxY] = arr[i][maxY];
		arr[min+1][maxY] = temp;
	}
}

