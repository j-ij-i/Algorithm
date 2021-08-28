import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413 {

	public static void main(String[] args) throws IOException {
//		String str = "STRING";
//		StringBuffer sb = new StringBuffer(str);
//		String rvsb = sb.reverse().toString();
//		
//		System.out.println(rvsb);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		boolean flag = false;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i)=='<') {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				flag = true;
			}
			if(flag == false) {
				if(str.charAt(i)== ' ') {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(' ');
				}else {
					stack.add(str.charAt(i));
				}
			}else if(flag == true) {
				System.out.print(str.charAt(i));
				if(str.charAt(i) == '>') {
					flag = false;
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

}
