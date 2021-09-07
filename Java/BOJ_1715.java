
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1715 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr [] = new int[N];
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 0 ; i < N ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int total = 0;
		
		while(pq.size()>1) {
			int q1 = pq.poll();
			int q2 = pq.poll();
			
			total += q1 + q2;
			pq.add(q1+q2);
		}

		System.out.println(total);
	}

}
