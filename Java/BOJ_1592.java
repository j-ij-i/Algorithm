import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N+1];
		int curP = 1;
		int cnt = 0;
		while(true) {
			arr[curP]++;
			if(arr[curP] >= M)
				break;
			
			cnt++;
			if(arr[curP] % 2 == 0) {
				for(int i = 0; i<L ; i++) {
					curP -= 1;
					if(curP < 1)
						curP = N;
				}
			}else {
				for(int i = 0; i<L ; i++) {
					curP += 1;
					if(curP > N) {
						curP = 1;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
