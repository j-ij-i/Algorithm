package algo_0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1062 {
	static int targetK, cnt, listSize, Max;
	static List<Character> list;
	static String[] strArr;
	static int[] selected;
	static boolean[] visited;
	static String[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new String[N];
		for(int i = 0 ; i< N ;i++) {
			arr[i] = br.readLine();
		}
		
		for(int k = 0 ; k < N ; k++) {
			while(true) {
				int init = arr[k].length();
				arr[k] = arr[k].replace("a", "");
				arr[k] = arr[k].replace("n", "");
				arr[k] = arr[k].replace("t", "");
				arr[k] = arr[k].replace("i", "");
				arr[k] = arr[k].replace("c", "");
				if(init == arr[k].length())
					break;
			}
		}
		list = new LinkedList();
		for(int k = 0 ; k < N ; k++) {
			for(int b = 0 ; b <arr[k].length(); b++) {
				if(k == 0 && b == 0) {
					list.add(arr[k].charAt(b));
				}else {
				boolean flag = true;
				for(int l = 0 ; l <list.size() ; l++) {
					if(arr[k].charAt(b)==list.get(l))
						flag = false;
				}
				if(flag == true) {
					list.add(arr[k].charAt(b));
				}
				}
			}
		}
		targetK = K-5;
		listSize = list.size();
		visited = new boolean[listSize];
		selected = new int[targetK];
		strArr = new String[list.size()];
		for(int k = 0 ; k < list.size(); k++) {
			strArr[k] = list.get(k).toString();
		}
		Max = 0;
		if(K < 5) {
			System.out.println(0);
		}else if(K == 5) {
			for(int k = 0 ; k < N ; k++) {
				if(arr[k].length() == 0)
					cnt++;
			}
			System.out.println(cnt);
		}
		else{
			comb(0);
			System.out.println(Max);
		}
	}
	
	
	private static void comb(int ct) {
		if(ct == targetK) {
			int count = 0;
			String Narr[] = new String[arr.length];
			for(int i = 0 ; i < arr.length; i++) {
				Narr[i] = arr[i];
 			}
			for(int a = 0 ; a <Narr.length ; a++) {
			for(int k = 0 ; k < selected.length ; k++) {
				while(true) {
					int init = Narr[a].length();
					Narr[a] = Narr[a].replace(strArr[selected[k]], "");
					if(init == Narr[a].length())
						break;
				}
			}
			if(Narr[a].length() == 0) {
				count++;
			}
			}
			Max = Math.max(Max, count);
			return;
		}
		for(int i=0; i<listSize; i++) {
			if(!visited[i]){ 
				visited[i] = true;
				selected[ct] = i;
				comb(ct+1);				
				visited[i] = false;
			}
		}
		
	}

}
