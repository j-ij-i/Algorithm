package algo_0112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_2251_SOL {

	static int[] arr;
	static boolean[][] check;
	static Set<Integer> answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		arr = new int[3];
		check = new boolean[201][201];
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = new TreeSet<>();
		dfs(0,0, arr[2]);
		
		for(int num : answer) {
			System.out.print(num+" ");
		}
	}
	static void dfs(int a, int b, int c){
		if(check[a][b]) return;
		
		if(a==0) {
			answer.add(c);
		}
		check[a][b] = true;
		// 0 -> 1
		if(a+b > arr[1]) {
			dfs((a+b)-arr[1], arr[1], c);
		}else {
			dfs(0, a+b, c);
		}
		
		// 1 -> 0
		if(a+b > arr[0]) {
			dfs(arr[0], a+b-arr[0], c);
		}else {
			dfs(a+b, 0, c);
		}
		// 2 -> 0
		if(a+c > arr[0]) {
			dfs(arr[0], b, a+c-arr[0]);
		}else {
			dfs(a+c, b, 0);
		}
		
		
		// 2 -> 1
		if(b+c > arr[1]) 	{
			dfs(a, arr[1], b+c-arr[1]);
		}else {
			dfs(a, b+c, 0);
		}
		
		// 0 -> 2
		dfs(a, 0, b+c);
		// 1 -> 2
		dfs(0, b, a+c);
	}
}
