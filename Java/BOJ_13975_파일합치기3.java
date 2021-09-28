import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13975 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			long K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			
			for(int k = 0 ; k < K ; k++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			long sum = (long)0;
			while(pq.size()>1) {
				long page1 = pq.poll();
				long page2 = pq.poll();
				long psum = page1 + page2;
				pq.add(psum);
				sum += psum;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}

