package algo_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281 {
	static int start,max,N;
	static int number[];
	static int inning[][];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		inning = new int[N][9];
		for(int n = 0 ; n < N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 9 ; i++) {
				inning[n][i]= Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[9];
		number = new int[9];
		visited[3] = true;
		number[0] = 0;
		start = 0;
		max = Integer.MIN_VALUE;
		permu(0);
		System.out.println(max);
	}

	private static void permu(int cnt) {
		if(cnt == N) {
			
			int outCnt = 0;
			while(outCnt<3) {
				if(number[start] == 0) {
					outCnt++;
				}
			}
			return;
		}
		for(int x = 1 ; x <= 8 ; x++) {
			if(visited[x]== false) {
				visited[x] = true;
				permu(cnt+1);
				visited[x] = false;
			}
		}
		
	}
}
