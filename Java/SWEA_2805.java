import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(in.readLine());
		for(int i = 0 ; i< tc ; i++) {
			int num = Integer.parseInt(in.readLine());
			int result = 0;
			char arr[][] = new char[num][num];
			for(int j = 0 ; j < num ; j++) {
				String line = in.readLine();
				arr[j] = line.toCharArray();
			}
			int halfcount = num/2;
			int start = halfcount;
			int end = halfcount;
			for(int j = 0 ; j < num ; j++) {
				if(halfcount >= j) {
					for(int t = start ; t<=end ; t++) {
						result += (int)arr[j][t]-'0';
					}
					if(start>0 && end<(num-1)) {
					start--;
					end++;
					}
				}
				else if(halfcount<j){
					start++;
					end--;
					for(int t = start ; t<=end ; t++) {
						result += (int)arr[j][t]-'0';
					}
				}
			}
			sb.append("#").append(i+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
