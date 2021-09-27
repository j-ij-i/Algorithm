import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo1_서울_8반_이선민 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader를 통해 받아오기
		StringBuilder sb = new StringBuilder(); // sb를 통해  문자열 받기
		StringTokenizer st; //StringTokenizer를 통해 문자열 나눠서 받기
		st = new StringTokenizer(br.readLine()); // 토큰 선언
		int M = Integer.parseInt(st.nextToken()); // M 초기화
		int N = Integer.parseInt(st.nextToken()); // N 초기화
		String arr[][] = new String[N-M+1][2]; //받아올 숫자들의 순서를 알기 위해 arr배열을 2차원 배열 형태로 만들고  [n][0]에는 해당 알파벳, [n][1]에는 해당 숫자를 넣어준다.
		for(int i = M ; i <= N ; i++) {
			sb.setLength(0); // sb를 사용하기 위해 초기화해준다.
			String num = Integer.toString(i); // 숫자를 String으로 만들어 문자열로 만들어준다.
			for(int j = 0 ; j < num.length() ; j++) { //숫자의 자릿수만큼 for문을 돌면서 문자열 넣기
				char n = (num.charAt(j)); // 숫자 한자리만 char형으로 받아오기
				if(n == '1') { 
					sb.append("o"); // 1이면 o
				}else if(n == '2') {
					sb.append("tw"); // 2는 t만 받게되면 3와 겹칠 수 있어 구분하기위해 tw까지 써준다.
				}else if(n == '3') {
					sb.append("th"); // 3는 t만 받게되면 2와 겹칠 수 있어 구분하기위해 th까지 써준다.
				} else if(n == '4') {
					sb.append("fo"); // 4는 f만 받게되면 5와 겹칠 수 있어 구분하기위해 fo까지 써준다.
				}else if(n == '5') {
					sb.append("fi"); // 5는 f만 받게되면 4와 겹칠 수 있어 구분하기위해 fi까지 써준다.
				}else if(n == '6') {
					sb.append("si"); // 6는 s만 받게되면 7와 겹칠 수 있어 구분하기위해 si까지 써준다.
				}else if(n == '7') {
					sb.append("se"); // 7는 s만 받게되면 6와 겹칠 수 있어 구분하기위해 se까지 써준다.
				}else if(n == '8') {
					sb.append("e");  // 8이면 e
				}else if(n == '9') { 
					sb.append("n");  // 9이면 n
				}else if(n == '0') { 
					sb.append("z");  // 0이면 z
				}
			}
			arr[i-M][0] = sb.toString(); // [0]에는 숫자를 알파벳으로 만든 문자열을 넣어준다.
			arr[i-M][1] = num; //[1]에는 원래숫자가 들어있는 문자열 num을 넣어준다
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0].compareTo(o2[0])); // arr[][0]에 담겨진 알파벳을 비교하기 위해 compareTo를 사용한다.
		int cnt = 0; // 10개단위로 끊기위해 사용하는 cnt
		for(int i = 0 ; i < arr.length ; i++) {
			cnt ++; //한개 출력할때마다 cnt 증가
			System.out.print(arr[i][1]+" "); //arr의 원래 숫자 출력
			if(cnt != 0 && cnt % 10 == 0) { //만약에 cnt가 0이아니면서 10개가 되면 줄바꿈을 한다.
				System.out.println(); //줄바꿈
			}
		}	
	}
}
