
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2810 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 1;
		for(int i = 0 ; i < N ;) {
			if(str.charAt(i) == 'S') {
				cnt++;
				i++;
				if(cnt > N)
					cnt = N;
			}
			else if(str.charAt(i) == 'L') {
				cnt++;
				i+=2;
				if(cnt > N)
					cnt = N;
			}
		}
		System.out.println(cnt);
	}

}
