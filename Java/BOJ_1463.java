//1로 만들기
//https://www.acmicpc.net/problem/1463 
import java.util.Scanner;

public class BOJ_1463 {
	static int[] memo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n + 1];
		System.out.println(f(n));
		for(int i = n ; i >= 0 ; i--) {
			System.out.print(memo[i]+" ");
		}

	}

	private static int f(int n) {
		if (n == 1) {
			return 0;
		}
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + 1;
			if (i % 3 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 3] + 1);
			}
			if (i % 2 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 2] + 1);
			}
		}
		return memo[n];
	}
}
