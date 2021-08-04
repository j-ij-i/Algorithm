import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int sum= 0;
		int T = Integer.parseInt(in.readLine());
		for(int i = 0 ; i<T ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr[][] = new int [N][N];
		
			for(int j = 0 ; j < N ; j++) {
				StringTokenizer st2 = new StringTokenizer(in.readLine()," ");
				for(int t= 0 ; t < N ; t++) {
					arr[j][t] = Integer.parseInt(st2.nextToken());
				}
			}
			int Max = 0;
			for(int j = 0 ; j < N ; j ++) {
				for(int t = 0; t <N ; t++) {
					sum = 0;
					//MxM 탐색
					if(j+M-1<N && t+M-1<N) {
					for(int d = j ; d <= j+M-1 ; d++) {
						for(int x = t ; x <= t+M-1; x++) {
							sum = sum + arr[d][x];
							}
						}
					}
					if(Max<sum) {
						Max = sum;
					}
				}
			}
			sb.append("#").append(i+1).append(" ").append(Max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
