import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N,R;
    static int[] numbers;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        numbers = new int[R];
        isSelected = new boolean[N+1];
        permutation(0);
        System.out.println(sb.toString());
    }
	private static void permutation(int cnt) {
		if(cnt == R) {
			//System.out.println(Arrays.toString(numbers));
			for(int j = 0 ; j< numbers.length; j++ ) {
				sb.append(numbers[j]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N ; i++) {
			if(isSelected[i]) continue;
			numbers[cnt]=i;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}