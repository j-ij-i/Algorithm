import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 0 && i != j) {
						arr[i][j] = 1001;
					}
				}
			}
			for(int k = 0 ; k < N ; k++) {
				for(int i = 0 ; i < N ; i++) {
					for(int j = 0 ; j < N ; j++) {
						arr[i][j] = Math.min((arr[i][k] + arr[k][j]), arr[i][j]);
					}
				}
			}
			int result = Integer.MAX_VALUE;
			for(int i = 0; i < N ; i++) {
				int sum = 0;
				for(int j = 0 ; j<N ;j++) {
					sum += arr[i][j];
				}
				result = Math.min(sum, result);
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
