import java.util.Scanner;

public class BOJ_15650 {
	static int N,count;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		count = sc.nextInt();
		isSelected = new boolean[N];
		f(0,0);
		System.out.println(sb.toString());
	}
	
	private static void f(int idx, int cnt) {
		if(idx == N) {
			if(cnt==count) {
				for(int i = 0 ; i < N ; i++) {
					if(isSelected[i])
						sb.append(i+1).append(" ");
				}
				sb.append("\n");
			}
			return;
		}
		isSelected[idx] = true;
		f(idx+1, cnt+1);
		isSelected[idx] = false;
		f(idx+1, cnt);
	}
}
