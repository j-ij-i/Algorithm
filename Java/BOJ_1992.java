
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
	static int N;
	static int arr [][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr= new int[N][N];
		for(int i = 0 ; i < N ;i++) {
			String str = br.readLine();
			for(int j = 0; j <N ; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		jg(0,0,N);
		System.out.println(sb.toString());
	}
	
	private static boolean isPoss(int startx, int starty, int n2) {
		int flag = arr[startx][starty];
		for(int i = startx ; i <startx+n2 ; i++) {
			for(int j = starty ; j < starty+n2; j++) {
				if(flag != arr[i][j])
					return false;
			}
		}
		return true;
	}
	
	private static void jg(int startx, int starty, int N) {
		if(isPoss(startx,starty,N)) {
			sb.append(arr[startx][starty]);
		}else {
			sb.append("(");
			jg(startx, starty, N/2);
			jg(startx, starty+(N/2), N/2);
			jg(startx+(N/2), starty, N/2);
			jg(startx+(N/2), starty+(N/2), N/2);
			sb.append(")");
		}
	}
}
