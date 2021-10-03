import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2846_오르막길 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int preNum = 0;
		int upCnt = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int curNum = Integer.parseInt(st.nextToken());
			if(preNum != 0) {
				if(curNum > preNum) {
					upCnt += (curNum - preNum);
					if(upCnt > max)
						max = upCnt;
				}else {
					upCnt = 0;
				}
			}
			preNum = curNum;
		}
		System.out.println(max);
	}
}
