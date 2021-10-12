package algo_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] child = new int[N];
        for (int i = 0; i < N; i++) {
        	child[i] = Integer.parseInt(br.readLine());
        }

        int num = 0;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (child[j] < child[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            num = Math.max(num, dp[i]);
        }

        System.out.println(N - num);
    }

}
