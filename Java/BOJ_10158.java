import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158 {

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
		
		int dx = 1;
		int dy = 1;
		
		while(true) {
			antx += dx;
			anty += dy;
			t++;
			
			if((anty >= y && antx >= x)|| (anty <= 0 && antx <= 0) || (anty >= y && antx <= 0) || (antx >= x && anty <= 0)) {
				dy *= -1;
				dx *= -1;
			}
			else if(anty >= y || anty <= 0) {
				dy *= -1;
			}else if(antx >= x || antx <= 0) {
				dx *= -1;
			}
			
			if(T == t)
				break;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(anty).append(' ').append(antx);
		System.out.println(sb.toString());
	}

}
