import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int N = str.length();
		int y = Integer.MAX_VALUE;
		int x = 0;
		for(int i = 1; i < N ; i++) {
			if(N%i==0 && i <= N/i) {
				x = i;
				y = N/i;
			}
		}
		char arr[][] = new char[x][y];
		
		int cnt = 0;
		for(int j= 0 ; j <y ; j++ ) {
			for(int i = 0 ; i < x ; i ++) {
				arr[i][j] = str.charAt(cnt++);
			}
		}
		
		for(int i = 0 ; i < x ; i ++) {
			for(int j= 0 ; j <y ; j++ ) {
				System.out.print(arr[i][j]);
			}
		}
		
	}

}
