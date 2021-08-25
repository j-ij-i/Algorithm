import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;  i<N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int sum = 0;
		int x = 0;
		for(int i = 0 ; i <N ; i++) {
			for(int j = 0 ; j <= x ;j++) {
				sum += arr[j];
			}
			x++;
		}
		System.out.print(sum);
	}

}
