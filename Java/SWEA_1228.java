

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1228 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= 10; i++) {
			int N = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<Integer>();
			for(int j = 0 ; j<N; j++) {
				int data = sc.nextInt();
				list.add(data);
			}
			int NC = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();		
			String []Num = str.split("I ");
			for(int a = 0; a<Num.length; a++) {
				String []CodeArr= Num[a].split(" ");
				if(CodeArr[0].equals(""))
					continue;
				int start = Integer.parseInt(CodeArr[0]);
				for(int c = 2; c < CodeArr.length; c++ ) {
					list.add(start, Integer.parseInt(CodeArr[c]));
					start++;
				}
				}
				sb.append("#").append(i).append(" ");
				for(int x = 0 ; x < 10 ; x++) {
					sb.append(list.get(x)).append(" ");
				}
				sb.append("\n");
			}
			
		System.out.println(sb.toString());
		}

	}


