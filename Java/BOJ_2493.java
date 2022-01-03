import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int Arr[] = new int[N+1];
		int result[] = new int[N+1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 1; i <= N ; i++) {
        	Arr[i] = Integer.parseInt(st.nextToken());
        	for(int j = i-1; j>0;) {
        		if(Arr[j]>Arr[i]) {
        			result[i]=j;
        			break;
        		}
        		j = result[j];
        	}
        	sb.append(result[i]).append(" ");
        }
		System.out.println(sb.toString());
	}
}
