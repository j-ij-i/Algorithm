
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> ppq = new PriorityQueue<>(); // 양수 정렬 큐
		PriorityQueue<Integer> mpq = new PriorityQueue<>(Collections.reverseOrder()); // 음수 정렬 큐
		for(int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(br.readLine());
			//0이면 큐 poll
			if(num == 0 ) {
				if(ppq.size() == 0 && mpq.size() == 0) {
					sb.append("0").append("\n");
				}else if(ppq.size() == 0) {
					sb.append(mpq.poll()).append("\n");
				}else if(mpq.size() == 0) {
					sb.append(ppq.poll()).append("\n");
				}else {
					int a = Math.abs(mpq.peek()) <= Math.abs(ppq.peek()) ? mpq.poll() : ppq.poll();
					sb.append(a).append("\n");						
				}
			}else {
				if(num > 0 )
					ppq.add(num);
				else if(num < 0)
					mpq.add(num);
			}
		}
		System.out.print(sb.toString());
	}

}
