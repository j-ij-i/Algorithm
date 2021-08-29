import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2851 {
	//슈퍼 마리오
	//https://www.acmicpc.net/problem/2851
	static int Max ; 
	static boolean visited[];
	static int arr [];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		arr= new int[10];
		for(int i = 0 ; i < 10 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		visited = new boolean[10];
		Max = 0;
		subset(0,0, true);
		System.out.println(Max);
	}
	private static void subset(int i, int sum, boolean flag) {
		if(i == 10) {
		if(Math.abs(100-Max) >= Math.abs(100-sum)) {
			if(Math.abs(100-Max) == Math.abs(100-sum) ) {
				Max = Math.max(Max, sum);
			}else Max = sum;
				return;
			}return;
		}else if(flag == false) {
			if(Math.abs(100-Max) >= Math.abs(100-sum)) {
				if(Math.abs(100-Max) == Math.abs(100-sum) ) {
					Max = Math.max(Max, sum);
				}else Max = sum;
					return;
				}return;
		}
		subset(i+1, sum+arr[i], true);
		subset(i+1, sum, false);
	}
	

}
