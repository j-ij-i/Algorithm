
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5644 {
	static User uA;
	static User uB;
	static Battery bty[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int dx[] = {0, -1, 0, 1, 0};
		int dy[] = {0, 0, 1, 0, -1};
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <= T ; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int userA[] = new int[M+1];
			int userB[] = new int[M+1];
			
			st = new StringTokenizer(br.readLine());
			for(int a = 1 ; a <=M ; a++) {
				userA[a] = Integer.parseInt(st.nextToken());
 			}

			st = new StringTokenizer(br.readLine());
			for(int a = 1 ; a <= M ; a++) {
				userB[a] = Integer.parseInt(st.nextToken());
 			}

			bty = new Battery[A+1]; 
			for(int a = 1 ; a <=A ; a++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int boundary = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				bty[a] = new Battery(a,y,x,boundary,power);
			}
			
			uA = new User(1,1,0,0);
			uB = new User(10,10,0,0);
			int AbtySum = 0;
			int BbtySum = 0;

			for(int t = 0 ; t <= M ; t++) {
				//맨처음 이동하기 전에 배터리에 현재 위치하는지 확인해야함
				uA.battery = 0;
				uB.battery = 0;
				uA.imsi = 0;
				uB.imsi = 0;
				//현재 어떤 배터리에 있는지 판단
				for(int a = 1 ; a <=A ; a++)  {
					Calc(bty[a], uA);
					Calc(bty[a], uB);
				}
				//2개이상의 배터리 영역내에 있다면 더 큰 파워쪽으로 넣어줬기 때문에 같은 영역내에 있을 수 있음
				int Ab = 0; //A가 있는 영역 배터리 에너지
				int Bb = 0; //B가 있는 영역 배터리 에너지
				
				if(uA.battery != 0) Ab = bty[uA.battery].power;
				else Ab = 0;
				if(uB.battery != 0) Bb = bty[uB.battery].power;
				else Bb = 0;		
				
				//0이 아니면서 같은 배터리에 있다면
				if(uA.battery == uB.battery && uA.battery!=0) {
					//두 사람이 다른 배터리로 갈 수 있는지 확인해야함
					//둘다 다른 배터리로 갈데가 없다면 반으로 배터리 나눔
					if(uA.imsi == 0 && uB.imsi == 0) {
						Ab = Ab/2;
						Bb = Bb/2;
					}else if(uA.imsi != 0 && uB.imsi == 0) {
						Ab = bty[uA.imsi].power;
					}else if(uA.imsi == 0 && uB.imsi != 0) {
						Bb = bty[uB.imsi].power;
					}else if(uA.imsi != 0 && uB.imsi != 0) { //두쪽 다 임시가 있으면 두쪽의 임시배터리중 파워가 더 큰쪽으로 선택	
						if(bty[uA.imsi].power > bty[uB.imsi].power) {
							Ab = bty[uA.imsi].power;
						}else{
							Bb = bty[uB.imsi].power;
						}
					}
				}
				//배터리 합계 계산
				AbtySum = AbtySum + Ab;
				BbtySum	= BbtySum + Bb;
				//마지막 이동이 아니면 한칸 이동
				if(t<M) {
					uA.x = uA.x + dx[userA[t+1]];
					uA.y = uA.y + dy[userA[t+1]];
					uB.x = uB.x + dx[userB[t+1]];
					uB.y = uB.y + dy[userB[t+1]];
				}
			}
			sb.append("#").append(i).append(" ").append(AbtySum+BbtySum).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static void Calc(Battery bt, User u) {
		int D = Math.abs(bt.x - u.x) + Math.abs(bt.y - u.y);
		if(D <= bt.boundary) {
			//그냥 비어있을 떄랑 
			if(u.battery == 0) {
				u.battery = bt.num;
			}
			//이미 가지고 있는 배터리가 있을 때 임시 배터리에 넣어줌
			else if(u.battery!= 0 && bty[u.battery].power <  bt.power) {
				u.imsi = u.battery;
				u.battery = bt.num;
			}else if(u.battery!= 0 && bty[u.battery].power >= bt.power) {
				if(u.imsi == 0) {
					u.imsi = bt.num;
				}else{
					if(bty[u.imsi].power < bt.power)
						u.imsi = bt.num;
				}
			}
		}
	}
}

class User{
	int x;
	int y;
	int battery;
	int imsi;
	
	public User(int x, int y, int battery, int imsi) {
		super();
		this.x = x;
		this.y = y;
		this.battery = battery;
		this.imsi = imsi;
	}
}


class Battery{
	int num;
	int x;
	int y;
	int boundary;
	int power;
	
	public Battery(int num, int x, int y, int boundary, int power) {
		super();
		this.num = num;
		this.x = x;
		this.y = y;
		this.boundary = boundary;
		this.power = power;
	}
	
	
}