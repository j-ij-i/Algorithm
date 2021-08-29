import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2477 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> list;
		ArrayList<len> ar3[] = new ArrayList[5]; 
		int K = Integer.parseInt(br.readLine());
		int arr[] = new int[6]; 
		int arr2[] = new int[6];
		int totalSize = 1;
		int miniSize = 1;

		for(int i = 1 ; i <= 4 ; i++) {
			ar3[i] = new ArrayList();
		}
		
		for(int i = 0; i < 6 ; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int sz = Integer.parseInt(st.nextToken());
			arr[i] = dir;
			arr2[i] = sz;
		}
		
		for(int i = 0 ; i<6 ; i++) {
			boolean flag = false;
			int nextNum = 0;
			int preNum = 0;
			if(i+1 >= 6) {
				nextNum = 0;
			}else nextNum = i+1;
			
			if(i-1 < 0 ) {
				preNum = 5;
			}else preNum = i-1;
			
			if(arr[preNum] == arr[nextNum]) {
				flag = true;
			}
			
			ar3[arr[i]].add(new len(arr[i],arr2[i],flag));
		}
		
		for(int i = 1 ; i <=4 ;i++) {
			if(ar3[i].size()==1) {
				totalSize *= ar3[i].get(0).sizes;
			}else {
				for(int j = 0 ; j <= 1 ; j++) {
					if(ar3[i].get(j).f == true) {
						miniSize *= ar3[i].get(j).sizes;
					}
				}
			}
		}
		
		System.out.println(K*(totalSize-miniSize));
		
	}

}

class len{
	int num;
	int sizes;
	boolean f;
	public len(int num, int sizes, boolean f) {
		super();
		this.num = num;
		this.sizes = sizes;
		this.f=f;
	}
	
	
}
