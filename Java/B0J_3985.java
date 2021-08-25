import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3985 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		boolean arr[] = new boolean[L+1];
		int end = 0;
		int maxCake = Integer.MIN_VALUE;
		int thinkMax = Integer.MIN_VALUE;
		int thinkres = 0;
		int result = 0;
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int ps = Integer.parseInt(st.nextToken());
			int pe = Integer.parseInt(st.nextToken());
			int sum = 0;
			if(thinkMax < (pe-ps+1)) {
				thinkMax = pe-ps+1;
				thinkres = i;
			}
			
			for(int j = ps; j <= pe ; j++) {
				if(arr[j]==false) {
					arr[j] = true; 
					sum++;
				}else continue;
			}
			if(sum > maxCake) {
				maxCake = sum;
				result = i;
				}
		}
		
		System.out.println(thinkres);
		System.out.println(result);
	}

}
