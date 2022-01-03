import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 10;
		int arr[] = new int[100];
		int[] result = new int[10];
		for(int i= 0 ; i < tc ; i++) {
		int count = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		for(int j = 0 ; j < 100 ; j++) {
			arr[j] = Integer.parseInt(st.nextToken());
		}
		
		for(int j = 0 ; j < count ; j++) {
			Arrays.sort(arr);
			arr[0]++;
			arr[99]--;
		}
		Arrays.sort(arr);
		int a = arr[99] - arr[0];
		sb.append("#").append(i+1).append(" ").append(a).append("\n");
		}
		System.out.println(sb.toString());
	}
}
