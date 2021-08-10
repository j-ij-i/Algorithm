import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {

	public static void main(String[] args) throws IOException {
	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	StringTokenizer st ;
	
	st= new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
	int K = Integer.parseInt(st.nextToken());
	int maxNum = N;
	int count = K;
	sb.append("<");
	Queue <Integer> list = new LinkedList<Integer>();
	for(int i = 1 ; i<=N; i++) {
		list.add(i);
	}
	while(!list.isEmpty()) {
		for(int i = 1; i <K ; i++) {
			int a = list.poll();
			list.add(a);
		}
		int res = list.poll();
		if(!list.isEmpty())
		sb.append(res).append(",").append(" ");
		else
		 sb.append(res);
	}
	
	sb.append(">");
	System.out.println(sb.toString());
//	for(int i = 1 ; i<=N; i++) {
//		if(list.size()>1)
//			sb.append(list.get(K-1)).append(",").append(" ");
//		else {
//			sb.append(list.get(K-1));
//			System.out.println(list.get(K-1));
//			break;
//		}
//		System.out.println("maxNum:"+ maxNum);
//		System.out.println(K-1);
//		//System.out.println(list.get(K-1));
//		//list.remove(K-1);
//	
//		if( count+K<=maxNum-1)
//			K= K+count;
//		else {
//			K= K+count-maxNum;
//			while(K>maxNum) {
//				K=K-maxNum;
//			}
//		}
//		maxNum = maxNum-1;
//	}
	
	}

}
