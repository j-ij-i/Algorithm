import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue <String> list = new LinkedList<String>();
		Scanner sc = new Scanner(System.in);
		StringTokenizer st ;
		int isPossible = 1;
		for(int i = 1; i <= 10; i++) {
		int N = sc.nextInt();
		sc.nextLine(); //꼭 넣기..
		for(int j = 0; j <N ; j++) {
			String str_n = sc.nextLine();
			list.add(str_n);
		}
		isPossible = 1;	
			while(!(list.isEmpty())) {
				if(isPossible==0)
					break;
			String str = list.poll();
			//System.out.println(str);
			String[]arr = str.split(" ");			
			String node_imsi = arr[0];
			String pb_imsi = arr[1];
			int node = Integer.parseInt(node_imsi);
			char pb = (pb_imsi).charAt(0);
			//마지막이 아닌데 숫자가 나오는 경우
			if(node*2 <= N || node*2+1 <= N) {
				if(Character.isDigit(pb)) {
					isPossible = 0;
				}			
			}
			//마지막인데 숫자가 아닌경우
			else {
				if(!(Character.isDigit(pb))) {
			//		System.out.println(pb);
					isPossible = 0;
				}
			}
			}
			list.clear();
			sb.append("#").append(i).append(" ").append(isPossible).append("\n");
		}
		System.out.println(sb.toString());
	}
}
	
