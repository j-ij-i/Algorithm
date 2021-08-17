import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_2954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferedstream으로 입력을 한줄단위로 받아들인다.
		StringTokenizer st; // StringTokenizer로 받아오는 문자열의 공백을 처리하여 나타낸다.

		st = new StringTokenizer(br.readLine()); //StringTokenizer을 새로 선언해줌과 동시에 입력을 받아 바로 st의 토큰으로 들어가게 한다.
		
		while(st.hasMoreTokens()) { //토큰의 갯수만큼 while문이 돌아간다.
			String str2 = st.nextToken(); //토큰을 문자열에 넣는다.
			for(int i = 0 ; i < str2.length(); ) { // 문자열의 길이에 따라 for문이 돌아가면서 문자열 하나하나 실행한다.
				if(str2.charAt(i) == 'a' || str2.charAt(i) == 'e' || str2.charAt(i) == 'i' || str2.charAt(i) == 'o' || str2.charAt(i) == 'u') { //만약 모음이 나타난다면 발생하게 될 이벤트를 위해 if문을 넣는다.
					System.out.print(str2.charAt(i)); //모음이 나타나면 p와 다른 모음이 연달아 나오기 때문에 일단 출력을 해준 후에
					i = i+3; //i를 3번 뒤로 넘겨버린다.
				}else {
					System.out.print(str2.charAt(i)); //모음이 나타나지 않았다면 i를 그대로 입력 후 
					i = i+1; // i를 1만큼 증가시켜서 다음 i를 얻는다.
				}
			}
			System.out.print(" "); //다음 토큰은 공백으로 구분되어있기 때문에 토큰에 들어간 문자열이 끝나면 공백을 나타내 준다.
		}
		br.close(); // 받아온 버퍼를 닫아준다.
	}

}
