
import java.io.IOException;
import java.util.Scanner;

public class BOJ_1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int switchArr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			switchArr[i]= sc.nextInt();
		}
		
		int peopleCount = sc.nextInt();
		for(int i = 0 ; i < peopleCount ; i++) {
			int gender  = sc.nextInt();
			int Gswitch = sc.nextInt();
			
			if(gender == 1) {
				int cnt = Gswitch;
				while(Gswitch<=switchArr.length) {
					if(switchArr[Gswitch-1] == 1)
						switchArr[Gswitch-1] = 0;
					else
						switchArr[Gswitch-1] = 1;
					Gswitch+=cnt;
				}
			}
			
			else if(gender == 2){
				int count = 1;
				Gswitch -=1;
				if(switchArr[Gswitch] == 1)
					switchArr[Gswitch] = 0;
				else
					switchArr[Gswitch] = 1;
				
				while(true) {
					if((Gswitch-count)<0 || (Gswitch+count)>=n || switchArr[Gswitch-count] != switchArr[Gswitch+count]) {
						break;
					}else if(switchArr[Gswitch-count] == switchArr[Gswitch+count]){
						if(switchArr[Gswitch-count] == 1) {
							switchArr[Gswitch-count] = 0;
							switchArr[Gswitch+count] = 0;
						}
						else {
							switchArr[Gswitch-count] = 1;
							switchArr[Gswitch+count] = 1;
						}
					}
					count++;
				}
			}
			
		}
		for(int a = 0 ; a< switchArr.length ; a++) {
	        if (a!= 0 && a % 20 == 0) {
	            System.out.println();
	        }
				System.out.printf("%d ", switchArr[a]);
		}
	}
}
