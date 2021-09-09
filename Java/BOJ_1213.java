import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int apb[] = new int[26];
		boolean flag = true;
		int mid = 100;
		for(int i = 0 ; i < 26 ; i++) {
			apb[i] = 0;
		}
		for(int i = 0 ; i < str.length(); i++) {
			char a = str.charAt(i);
			int x = a-65;
			apb[x] += 1;
		}

		for(int i = 0 ; i < 26 ; i++) {
			if(apb[i]%2 == 1) {
				if(mid == 100) {
					mid = i;
					apb[i] -= 1;
				}else{
					flag = false;
					break;
				}
			}
				for(int j = 0 ; j < apb[i]/2 ; j++) {
					char s = (char)(i + 65);
					sb.append(s);
				}
				apb[i] = apb[i]/2;
			
		}
		if(mid!= 100) {
		sb.append((char)(mid+65));
		}
		if(flag==true) {
			for(int i = 25 ; i >=0 ; i--) {
					for(int j = 0 ; j < apb[i] ; j++) {
						char s = (char)(i + 65);
						sb.append(s);
					}
				}
			System.out.println(sb.toString());
		}
		else {
			System.out.println("I'm Sorry Hansoo");
		}
	}
}
