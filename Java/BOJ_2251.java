public class BOJ_2251 {
    
}
package algo_0112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2251 {
	static int A,B,C;
	static boolean water[];
	static int arr[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		arr = new int[2];
		arr[0]= Integer.parseInt(st.nextToken());
		arr[1]= Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		water = new boolean[C+1];
		PriorityQueue pq = new PriorityQueue<>();
		water[C] = true;
		pq.add(C);
		for(int i = 0 ; i < 2 ; i++) {
			//N에만 쏟고 난 후 남았을 때
			int N = C - arr[i];
			if(!water[N]&& N > 0 && N < C)pq.add(N);
			if(!water[arr[i]]&& arr[i] > 0 && arr[i] < C)pq.add(arr[i]);
		}

		//AB에 다쏟아붓고 난 후 
		int all = C-arr[0]-arr[1];
		if(all > 0 && all < C&&!water[all])pq.add(all);
		
		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+" ");
		}
	}

}
