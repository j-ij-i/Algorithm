import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17135 {
	static int N, M , D, maxKill;
	static ArrayList<index> Enemy;
	static ArrayList<index> Enemy_Clone;
	static HashSet<index> set;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new boolean[M+1];
		Enemy = new ArrayList<index>();
		maxKill = Integer.MIN_VALUE;
		for(int x = 1 ; x <= N ; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y = 1; y <= M ; y++) {
				int eny = Integer.parseInt(st.nextToken());
				if(eny==1) {
				Enemy.add(new index(x,y));
				}
			}
		}
		
//		for(int i = 0 ; i <N ; i++) {
//			System.out.println(Enemy.toString());
//			System.out.println("===============");
//			go();
//		}
		
	//	subset2(0,0);
		subset(0,0);
		System.out.println(maxKill);
		br.close();
	}
	
	public static int Calc(index i1, index i2) {
		return Math.abs(i1.x - i2.x) + Math.abs(i1.y - i2.y);
	}
	
//	public static void subset2(int cnt, int num) {
//		if(cnt == M) {
//			if(num == 3) {
//				for(int arc = 0 ; arc < M ; arc++) {
//					if(visited[arc] == true) {
//						System.out.print((arc+1)+" ");
//					}
//				}
//				System.out.println();
//			return;
//		}else return;
//		}
//		visited[cnt]= true;
//		subset2(cnt+1, num+1);
//		visited[cnt] = false;
//		subset2(cnt+1, num);		
//	}
	
	
	public static void subset(int cnt, int num) {
		if(cnt == M) {
			if(num == 3) {
				System.out.println("===========================");
				System.out.print("조합 : ");
				for(int arc = 0 ; arc < M ; arc++) {
					if(visited[arc] == true) {
						System.out.print((arc+1)+" ");
					}
				}
				System.out.println();
				int KillEnemy = 0;
				Enemy_Clone = new ArrayList<index>();
				
				System.out.println(Enemy.toString());
				System.out.println("===============");
			
				for(int i = 0 ; i < Enemy.size(); i++) {
					Enemy_Clone.add(new index(Enemy.get(i)));
				}
				int start= 1;
				while(!Enemy_Clone.isEmpty()) {
					System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ시작"+start+"ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
					set = new HashSet<>();
				for(int arc = 0 ; arc < M ; arc++) {
					if(visited[arc] == true) {
						index idx = null;
						int minCount = Integer.MAX_VALUE;
						for(int e = 0; e < Enemy_Clone.size() ; e++) {
							if(Calc(Enemy_Clone.get(e), new index(N+1,arc+1)) <= D){
							if(minCount > Calc(Enemy_Clone.get(e), new index(N+1,arc+1))) {
								System.out.println("최소거리발견! "+Calc(Enemy_Clone.get(e), new index(N+1,arc+1)));
								minCount = Calc(Enemy_Clone.get(e), new index(N+1,arc+1));
								idx = Enemy_Clone.get(e);
							}
							else if(minCount == Calc(Enemy_Clone.get(e), new index(N+1,arc+1))) {
								if(idx.y < Enemy_Clone.get(e).y)
									idx = Enemy_Clone.get(e);
							}
							}
						}
						System.out.println();
						if(idx!=null){
							set.add(idx);
							System.out.println("!!!!!!!!!!!!: "+idx);
						}
					}
				}
				KillEnemy = KillEnemy + set.size();
				Iterator<index> iter = set.iterator();
				while(iter.hasNext()) {
					Enemy_Clone.remove(iter.next());
				}
				go();
				start++;
			}
			Enemy_Clone.clear();	
			maxKill = Math.max(maxKill, KillEnemy);
			return;
		}else return;
		}
		visited[cnt]= true;
		subset(cnt+1, num+1);
		visited[cnt] = false;
		subset(cnt+1, num);
	}

	public static void go() {
		if(!Enemy_Clone.isEmpty()) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0 ; i < Enemy_Clone.size(); i++) {
			if((Enemy_Clone.get(i).x)+1 > N) {
				stack.add(i);
				System.out.println("Stack: "+stack.toString());
			}
			else
				Enemy_Clone.get(i).x += 1;
		}
		while(!(stack.isEmpty())) {
			int idx = stack.pop();
			Enemy_Clone.remove(idx);
		} 	
		}else return;
	}
}

class index{
	int x;
	int y;
	
	public index(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public index(index index) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "index [x=" + x + ", y=" + y + "]";
	}
	

}
