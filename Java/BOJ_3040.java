import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3040 {
	static boolean isSelected[] ;
	static int[] arr;
	static int[] result = new int[9];
	static int sum = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[10];
		isSelected = new boolean[10];
		for(int i = 0 ; i < 9 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		subset(0, 0, 0);
//		System.out.println(Arrays.toString(arr));
		System.out.println(sb.toString());
	}
	
	
	private static void subset(int cnt, int num, int sum) {
		if(cnt==9) {
			if(num==7 && sum==100) {
				for(int j = 0 ; j < 9; j++) {
					if(isSelected[j]==true)
					sb.append(arr[j]).append("\n");
				}
				return;
			}else return;
		}
		isSelected[cnt] = true;
		subset(cnt+1, num+1, sum+arr[cnt]);
		isSelected[cnt] = false;
		subset(cnt+1, num ,sum);
	}

}
