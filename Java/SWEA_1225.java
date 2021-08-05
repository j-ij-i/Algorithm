import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Scanner sc= new Scanner(System.in);
		Queue<Integer> queue;
		
		for(int tc = 1 ; tc<=10; tc++) {
			queue = new LinkedList<Integer>();
			int count = sc.nextInt();
			for(int j = 0 ; j <8; j++) {
				int a = sc.nextInt();
				queue.offer(a);
			}
			int i = 1;
						
			while(true) {
				if(i>5) {
					i=1;
				}
				if(queue.peek()-i <=0)break;
				int x = queue.peek()-i; 
				queue.poll();
				queue.offer(x);
				i++;
			}
			queue.poll();
			queue.offer(0);
			sb.append("#").append(tc).append(" ");
			for(int t= 0; t< 8; t++) {
				int a = queue.poll();
				sb.append(a).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
