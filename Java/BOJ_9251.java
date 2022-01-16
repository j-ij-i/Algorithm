import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		char s1[] = new char[str1.length()];
		for(int i = 0 ; i < str1.length(); i++) {
			s1[i] = str1.charAt(i);
		}
		String str2 = br.readLine();
		char s2[] = new char[str2.length()];
		for(int i = 0 ; i < str2.length(); i++) {
			s2[i] = str1.charAt(i);
		}
		
	}

}
