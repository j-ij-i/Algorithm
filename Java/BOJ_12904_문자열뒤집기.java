package algo_1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder S = new StringBuilder(br.readLine());
		StringBuilder T = new StringBuilder(br.readLine());
		
		while(S.length() < T.length()) {
			if(T.charAt(T.length()-1) == 'A') {
				T.deleteCharAt(T.length()-1);
			}else if(T.charAt(T.length()-1) == 'B'){
				T.deleteCharAt(T.length()-1);
				T.reverse();
			}
		}
		
		if(S.toString().equals(T.toString())) System.out.println(1);
		else System.out.println(0);
		
	}
}
