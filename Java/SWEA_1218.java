import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= 10 ;tc++) {
			int T = Integer.parseInt(in.readLine());
			String str = in.readLine();
			int valid = 1;
			while(true) {
				String g = "[]";
				str = str.replace("()","");
				str = str.replace("<>","");
				str = str.replace(g, "");
				str = str.replace("{}","");
				if(str.contains("()") || str.contains("<>") || str.contains(g) || str.contains("{}") ) {
					continue;
				}else if(str.length()==0) {
					break;
				}
				else {
					valid = 0;
					break;
				}
			}
			System.out.println(str);
			sb.append("#").append(tc).append(" ").append(valid).append("\n");	
		}
		System.out.println(sb.toString());
	}

}
