
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <=N ; i++) {
			String str = br.readLine();
			int totalSum = 0;
			int sum = 0;
			for(int j = 0 ; j < str.length() ; j++) {
				if(str.charAt(j)=='O') {
					sum++;
					totalSum += sum;
				}else sum = 0;
			}
			sb.append(totalSum).append("\n");
		}
		System.out.println(sb.toString());
	}

}
