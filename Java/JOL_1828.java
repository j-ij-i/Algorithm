import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JOL_1828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		temp[] t = new temp[N];
		int count = 1;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());			
			t[i] = new temp(x,y);
		}
		
		Arrays.sort(t);
		int max =t[0].y;
		for(int i = 1; i <N ; i++) {
			if(t[i].x > max) {
				count++;
				max = t[i].y;
			}
		}
		System.out.println(count);
		
	}
}
class temp implements Comparable<temp>{
	int x;
	int y;
	
	public temp(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "temp [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int compareTo(temp o) {
		return  this.y - o.y;
	}	
}
