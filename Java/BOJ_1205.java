import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		;
		int P = Integer.parseInt(st.nextToken());
		Integer arr[] = new Integer[N];

		if (N > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		} else {
			System.out.println("1");
			return;
		}
		if(N == P && arr[N-1] >= score) {
			System.out.println("-1");
			return;
		}else if(N < P && arr[N-1] > score ){
			System.out.println(N+1);
			return;
		}else {
			int result = 1;
			for (int i = 0; i < N; i++) {
				if(arr[i] > score){
					result++;
				}else 
					break;
			}
			System.out.println(result);
		}
	}
}