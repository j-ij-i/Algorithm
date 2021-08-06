
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		int stickCount;
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <=T ; i++) {
			String line = br.readLine();
			stickCount = 0 ;
			for(int j = 0 ; j < line.length() ; j++) {
				char c = line.charAt(j);
				if(c == '(') {
					stack.push(c);
				}else if( c == ')') {
					if(stack.size()>1 && line.charAt(j-1)=='(' ) {
					stack.pop();
					stickCount += stack.size();
					}
					else if(line.charAt(j-1) !='(') {
						stack.pop();
						stickCount += 1;
					}
					else
						stack.pop();
				}
			}
			sb.append("#").append(i).append(" ").append(stickCount).append("\n");
			stack.clear();
		}
		System.out.println(sb.toString());
	}
}
