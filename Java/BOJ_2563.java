import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sb.readLine());
        StringTokenizer st; 
        int[][] map = new int[100][100];
        int cnt = 0;
        for(int i = 1; i <= n ; i++) {
        	st = new StringTokenizer(sb.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	for(int xs = x ; xs< x+10 ; xs++) {
        		for(int ys = y ; ys < y+10; ys++) {
        			if(map[xs][ys]!=1) {
        				map[xs][ys]=1;
        				cnt++;
        			}else continue;
        		}
        	}
        }
        System.out.println(cnt);
	}
}
