import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	static int arr[][];
	static int result, size, r,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		size = 0;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		result = 0;
		z((int) Math.pow(2, N), 0, 0);
	}

	private static void z( int size, int x, int y) {
		if(x == r && y == c) {
			System.out.println(result);
			return;
		}
		if(x <= r && r< (x+size) && y <= c && c < (y+size)){
		 z(size/2, x, y); //1
		 z(size/2, x, y+size/2); //2
		 z(size/2, x+size/2, y); //3
		 z(size/2, x+size/2, y+size/2); //4
		}else{
			result += size*size;
		}
	}

}
