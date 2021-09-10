
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int anty = Integer.parseInt(st.nextToken());
		int antx = Integer.parseInt(st.nextToken());
		
		int T = Integer.parseInt(br.readLine());
		int t = 0;
		
		int divX = x/T;
		int divY = y/T;
		int modX = x%T;
		int modY = y%T;
		
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(anty).append(' ').append(antx);
		System.out.println(sb.toString());
	}

}
