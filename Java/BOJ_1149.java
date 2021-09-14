//RGB거리
//https://www.acmicpc.net/problem/1149

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int paint[][] = new int[N + 1][3];
		int dp[][] = new int[N + 1][3];
		for (int i = 1; i <=N; i++) {
			st = new StringTokenizer(br.readLine());
			paint[i][0] = Integer.parseInt(st.nextToken());
			paint[i][1] = Integer.parseInt(st.nextToken());
			paint[i][2] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <=N; i++) {
			dp[i][0] = Math.min(dp[i-1][2], dp[i-1][1])+paint[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+paint[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+paint[i][2];
		}
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]),dp[N][2]));

	}

}
