import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_3499 {
	static String str1[];
	static String str2[];
	static String result[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			int N = sc.nextInt();
			result = new String[N];			
			str1 = new String [N/2+1];
			str2 = new String [N/2];
			int a = 0;
			int b = 0;
			for(int x = 0 ; x < N ; x++) {
				int flag = N%2==0 ? N/2 : N/2+1;
				if(x < flag) {
					str1[a] = sc.next();
					a++;
				}
				else {
					str2[b] = sc.next();
					b++;
				}
			}
			a = 0;
			b = 0;
			sb.append("#").append(t).append(" ");
			for(int j = 0 ; j < N ; j++) {
				if(j%2 == 0) {
					sb.append(str1[a]+" ");
					a++;
				}else {
					sb.append(str2[b]+" ");
					b++;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
