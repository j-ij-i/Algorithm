import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <= T ; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] LIS = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int dp[] = new int[N+1];
			int max = 0;
			for(int j=0 ; j < N ; j++) {
				LIS[j] = 1; // 본인만 가질 경우를 기본으로 주고 시작.
				for(int d = 0 ; d < j ; d++) { //본인의 앞쪽 원소 탐색
					if(arr[j] > arr[d] && LIS[j] < LIS[d] +1) { //d번째 배열이 나보다 작고, d번째 배열에 들어가있는 LIS의 길이 나까지 합친 길이가 현재의 나보다 클 경우 
						LIS[j] = LIS[d]+1;
					}
				}
				if(max < LIS[j]) max = LIS[j];
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
