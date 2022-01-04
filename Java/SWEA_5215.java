import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
	static int arr[][] ;
	static int Maxcal,count,sum,N, MaxFlavor;
	static boolean flag[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <= T ; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Maxcal = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			flag = new boolean[N];
			MaxFlavor = 0;
			for(int j = 0 ; j < N ; j ++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			sum = 0;
			subset(0,sum);
			sb.append("#").append(i).append(" ").append(MaxFlavor).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	private static void subset(int count, int sum) {
		if(count == N){
		if (sum < Maxcal) {
			int imsiSum = 0;
			for (int i = 0; i < N; ++i) {
				imsiSum = flag[i] ? imsiSum+arr[i][0] : imsiSum+0;
			}
			if(MaxFlavor < imsiSum) {
				MaxFlavor = imsiSum;
			}
			return;
		}else return;
		}else if(sum > Maxcal) return;
		
		flag[count] = false;
		subset(count + 1, sum);
		
		flag[count] = true;
		sum = sum+arr[count][1];
		subset(count + 1, sum);
	}
}
