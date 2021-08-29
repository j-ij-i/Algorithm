import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2564 {
	static int arr[][] ;
	static int x,y,sum;
	static ArrayList<Store> store;
	static DK dk; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		store = new ArrayList<Store>();
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int [x][y];
		sum = 0;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			int s1= Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			whereis(1,s1,s2);
		}
		st = new StringTokenizer(br.readLine());
		int s1= Integer.parseInt(st.nextToken());
		int s2 = Integer.parseInt(st.nextToken());
		whereis(0,s1,s2);
		
		for(int i = 0 ; i<store.size(); i++) {
			if(store.get(i).num == dk.num) {
				sum += Math.abs(store.get(i).x - dk.x)+ Math.abs(store.get(i).y - dk.y);
			}else if(( store.get(i).num <= 2 && dk.num <= 2 ) || ( store.get(i).num >= 3 && dk.num >= 3 ) ) {
				if(store.get(i).num >= 3) {
					int sum1 = y + store.get(i).x + dk.x; 
					int sum2 = y + (x-store.get(i).x) + ((x-dk.x));
					sum += Math.min(sum1, sum2);
				} else {
					int sum1 = x + store.get(i).y + dk.y; 
					int sum2 = x + (y-store.get(i).y) + ((y-dk.y));
					sum += Math.min(sum1, sum2);
				}
			}else {		
				sum += Math.abs(store.get(i).x - dk.x) + Math.abs(store.get(i).y - dk.y);
			}
		}
		System.out.println(sum);
		
	}
	private static void whereis(int flag, int s1, int s2) {
		int nx= 0;
		int ny= 0;
		if(s1 == 1) {
			nx = 0;
			ny = s2;
		}else if(s1 == 2) {
			nx = x;
			ny = s2;
		}else if(s1 == 3) {
			nx = s2;
			ny = 0;
		}else if(s1 == 4) {
			nx = s2;
			ny = y;
		}
	
		if(flag == 1) {
			store.add(new Store(nx,ny,s1));
		}else {
			dk = new DK(nx,ny,s1);
		}
		
	}

}



class Store{
	int x;
	int y;
	int num;
	
	public Store(int x, int y, int num) {
		super();
		this.x = x;
		this.y = y;
		this.num= num;
	}
}
class DK{
	int x;
	int y;
	int num;
	public DK(int x, int y, int num) {
		super();
		this.x = x;
		this.y = y;
		this.num= num;
	}
}
