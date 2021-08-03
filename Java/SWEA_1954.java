
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954_sol {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		int arr[] = new int[tc];
		for(int i = 0 ; i < tc ; i++ ) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		for(int i= 0 ; i<arr.length ; i++) {
			int size = arr[i];
			int snail[][] = new int[size][size];
			
			int x = 0;
			int y = 0;
			
			int [] dx= {0, 1 , 0, -1};
			int [] dy= {1, 0, -1, 0};
			
			int dir = 0;
			
			for(int j = 1 ; j <= size*size ; j++) {
				snail[x][y] = j;
				x += dx[dir];
				y += dy[dir];
				
				if(x>=size || y>= size || y<0 || x<0 || snail[x][y] !=0) {
					x -= dx[dir];
					y -= dy[dir];
					dir = (dir+1)%4;
					x += dx[dir];
					y += dy[dir];
				}
				
			}
			System.out.println("#"+(i+1));
			
			for(int j = 0 ; j<size; j++) {
				for(int k = 0 ; k <size; k++) {
					System.out.print(snail[j][k]+" ");
				}
				System.out.println();
			}
		}
		in.close();	
	}

}

