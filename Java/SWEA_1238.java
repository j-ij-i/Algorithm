import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {
	static List<Integer>[] list;
	static int[] numbers; //연락을 몇번째 depth에 받았는지
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1 ; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			//최대 연락 인원 100
			list = new ArrayList[101];
			//부여될 수 있는 번호 100이하
			numbers = new int[101];
			
			for(int x = 1 ; x <=100 ; x++) {
				list[x] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			for(int x = 0 ; x < N/2 ; x++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
			//BFS 돌린 결과를 값으로 받기
			int result = BFS(start);
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int BFS(int start) {
		numbers[start] = 1; //start는 1로 시작
		Queue<Integer> q = new LinkedList<>();
		q.offer(start); //맨 처음 값 큐에 넣어주기 
		while(!q.isEmpty()) {
			int n = q.poll(); //poll한 값을 n에 넣어
			for(int i = 0 ; i <list[n].size() ; i++) {
				int nxt = list[n].get(i); //n이 가지고 있는 리스트들을 뽑아낸다.
				if(numbers[nxt] == 0) {
					numbers[nxt] = numbers[n]+1; //만약에 연락받은 적 없다면 이전 distance+1만큼의 depth를 넣어줌
					q.offer(nxt);//n이 가지고 있는 리스트를 넣어줌
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int res = 0;
		for(int i= 1 ; i <= 100; i++) {
			if(max <= numbers[i]) {
				max = numbers[i];
				res = i;
			}
		}
		return res;
	}

}
