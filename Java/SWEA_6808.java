import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_bit {
	static int Ip=9, P=18, resultWin, resultLose, flag;
	static int arr[];
	static int Allnumbers[]; // 
	static int Pnumbers[] =  new int[10];
	static boolean[] isSelected;
	static int Iarr[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		for(int i = 1 ; i <= T ; i++) {
			arr = new int[10];
			Iarr = new int[10];
			Allnumbers = new int[19];
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c<=9; c++) {
				arr[c] = Integer.parseInt(st.nextToken());
				Allnumbers[arr[c]] = 1;
			}
			int cnt = 1;
			for(int c = 1 ; c<=18; c++) {
				if(Allnumbers[c]!=1) Iarr[cnt++]=c;
			}
			resultLose = 0;
			resultWin = 0;
			permutation(0, 0);
			sb.append("#").append(i).append(" ").append(resultWin).append(" ").append(resultLose).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	private static void permutation(int cnt, int flag) {
		if(cnt == 9 ) {
			int IPoint = 0;
			int MyPoint = 0;
			for(int j = 0 ; j < 9 ; j++) {
				if(Pnumbers[j] > arr[j+1] ) IPoint += Pnumbers[j]+arr[j+1];
				else if(Pnumbers[j] < arr[j+1] ) MyPoint += Pnumbers[j]+arr[j+1];
			}
			if(IPoint>MyPoint) resultLose++;
			else if(IPoint<MyPoint) resultWin++;
			return;
		}
		
		for(int i = 1; i <= 9 ; i++) {
			if((flag & 1<< i) != 0) continue;
			Pnumbers[cnt] = Iarr[i];
			permutation(cnt+1, flag|1 << i);
		}
	}
}
