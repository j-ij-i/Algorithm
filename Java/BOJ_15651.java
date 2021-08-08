import java.util.Scanner;

public class BOJ_15651 {
		static int N,M, Numbers[];
		static boolean[] isSelected;
		static StringBuilder sb = new StringBuilder();
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			M = sc.nextInt();
			N = sc.nextInt();
			Numbers = new int[N];
			f(0);
			System.out.println(sb.toString());
		}
		private static void f(int cnt) {
			if(cnt== N) {
				for(int i = 0 ; i < N ; i++) {
					sb.append(Numbers[i]).append(" ");
				}
				sb.append("\n");
				return;
			}
			for(int i = 1 ; i<= M ; i++) {
				Numbers[cnt] = i;
				f(cnt+1);
			}
		}
	}
