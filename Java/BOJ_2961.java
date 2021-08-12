import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
	static int min, T;
	static int sour [], bitter[];
	static boolean[] flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		sour = new int [T+1];
		bitter = new int [T+1];
		flag = new boolean[T+1];
		min = Integer.MAX_VALUE;
		for(int i = 1; i<= T ;i++ ) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i]= Integer.parseInt(st.nextToken());
		}
		subset(1,0);
		System.out.println(min);
	}
	
	private static void subset(int count, int falseCount) {
		if (count == T+1 && falseCount<T) {
			int sourCount = 1;
			int bitterCount = 0 ;
			for (int i = 1; i <= T; i++) {
				if(flag[i] == true) {
					sourCount *= sour[i];
					bitterCount += bitter[i];
				}else continue;
			}
			if(min > (Math.abs(sourCount-bitterCount)))
				min = Math.abs(sourCount-bitterCount);
			return;
		}else if(count == T+1 && falseCount>=T) return;

		flag[count] = true;
		subset(count + 1, falseCount);

		flag[count] = false;
		subset(count + 1, falseCount+1);
	}
}
