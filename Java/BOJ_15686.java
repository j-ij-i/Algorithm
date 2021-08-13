import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_15686 {
	static ArrayList<index> chicken;
	static ArrayList<index> house;
	static boolean [] isSelected;
	static int Resultmin, M, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		chicken = new ArrayList<index>();
		house = new ArrayList<index>();
		Resultmin = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<= N ; j++) {
				int idx = Integer.parseInt(st.nextToken());
				if(idx == 1){house.add(new index(i,j));}
				else if(idx == 2) {chicken.add(new index(i,j));}
			}
		}
		isSelected = new boolean[chicken.size()+1];
		chickenChoice(0, 0);
		System.out.println(Resultmin);
		br.close();
	}
	
	static void chickenChoice(int cnt, int x) {
		//치킨 M개 골라온 후 치킨M개for + 집 size 만큼 for문 돌려주기 - Calc로 비교
		if(cnt == chicken.size()) {
			if(x==M) {
				int min = 0;
				int minCount = Integer.MAX_VALUE;
				for(int p = 0; p < house.size(); p++) {
					minCount = Integer.MAX_VALUE;
					for(int c = 0 ; c<chicken.size(); c++) { //가장 가까운 치킨집 찾기
						if(isSelected[c]==true) {
							minCount = Math.min(minCount,  Calc(house.get(p),chicken.get(c)));
						}
					}
					min += minCount;
				}
				Resultmin = Math.min(min, Resultmin);
				return;
			}else return;
		}
		
		//치킨 골라오기
		isSelected[cnt] = true;
		chickenChoice(cnt+1, x+1);
		isSelected[cnt]= false;
		chickenChoice(cnt+1, x);
		
	}
	
	public static int Calc(index i1, index i2) {
		return Math.abs(i1.x - i2.x) + Math.abs(i1.y - i2.y);
	}

}

//class index{
//	int x;
//	int y;
//	
//	public index() {
//		super();
//	}
//
//	public index(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//
//	@Override
//	public String toString() {
//		return "index [x=" + x + ", y=" + y + "]";
//	}
//}