import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferedstream으로 입력을 한줄단위로 받아들인다.
		StringTokenizer st; // StringTokenizer로 받아오는 문자열의 공백을 처리하여 나타낸다.
		StringBuilder sb = new StringBuilder(); //StringBuilder로 출력 나타내기
		st = new StringTokenizer(br.readLine()); // //StringTokenizer을 새로 선언해줌과 동시에 입력을 받아 바로 st의 토큰으로 들어가게 한다.
		int R = Integer.parseInt(st.nextToken()); //토큰에 있는 R값 받아오기
		int C = Integer.parseInt(st.nextToken()); //토큰에 있는 C값 받아오기
		char arr[][] = new char[R+1][C+1]; //Map을 나타낼 char 배열 선언
		for(int r = 1; r <= R ; r++) {
			String str = br.readLine(); //줄 단위로 String을 받아옴
			for(int c = 1; c<= C ; c++) {
				arr[r][c]= str.charAt(c-1); //공백이 없기 때문에 String의 charAt으로 배열을 넣어줌
			}
		}
		int N = Integer.parseInt(br.readLine());// 떨어질 화산탄 갯수 N을 받아옴
		for(int n = 1 ; n<= N ; n++ ) { //화산탄 갯수만큼 돌려줌
			int y = Integer.parseInt(br.readLine());
			int x = 1;
			while(true) { //화산탄이 계속해서 내려가는 경우를 while문을 통해 계속 판단한다.
			 if(x+1<=R && arr[x+1][y]=='.') { //아래가 비어있는 경우
				x = x+1; // 한칸 밑으로 내려간다.
			 }else if( x+1 >R) { //맨 밑바닥 바닥이거나  밑이 장애물인 경우
				 arr[x][y] = 'O'; //화산탄은 그자리에 굳는다.
				 break; //while문 종료
			 }else if(arr[x+1][y]=='X') {
				 arr[x][y] = 'O'; //화산탄은 그자리에 굳는다.
				 break; //while문 종료
			 }
			 else if(arr[x+1][y]=='O') { //아래가 화산탄인 경우 
				 if(x+1<=R && y-1 >0 && arr[x+1][y-1] =='.' && arr[x][y-1] =='.') { //왼쪽과 왼쪽 아래가 .일경우
					 y= y-1; //y는 한칸 왼쪽으로
					 x= x+1; //x는 한칸 밑으로 진행
				 }else if(x+1<=R &&  y+1 <= C && arr[x+1][y+1] =='.' && arr[x][y+1] =='.') { //오른쪽과 오른쪽 아래가 .일경우
					 y= y+1; //y는 한칸 오른쪽으로
					 x= x+1; //x는 한칸 밑으로 진행
				 }else { // 모두 아닐경우
					arr[x][y] = 'O'; // 그자리에 화산탄이 굳고
					break; //while문 탈출
				 }
			 }
			}		
		}
		for(int r = 1; r <= R ; r++) { //바뀐 결과 출력
			for(int c = 1; c<= C ; c++) {
				sb.append(arr[r][c]); //배열을 StringBuilder에 넣기
			}
			sb.append("\n"); //한줄 출력 후 줄바꿈
		}
		System.out.println(sb.toString());//최종 결과 값 StringBuilder출력하기
	}
}
