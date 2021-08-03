import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1210 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int arr[][] = new int[100][100];
		int start = 0;
		int direction = 0;
		
		for(int i= 0 ; i < tc ; i++) {
		int count = sc.nextInt();
		for(int j = 0 ; j < 100 ; j++) {
			for(int k = 0 ; k < 100; k++) {
				arr[j][k] = sc.nextInt();
				if(arr[j][k]==2) {
				}
			}
		}
		//만약 첫줄에 1이 나오면 이제 while문 시작!
		//첫시작은 그냥 앞방향상태, 좌우앞 확인해야함
		//그리고 시작부터 좌우앞를 확인 하고 좌우에 암것도 없으면 앞으로, 좌 우 가있으면 좌우 방향으로 방향을 바꿔줌
		//근데 내가 현재 상태가 좌거나 우면 방향탐색에서 다른 방향을 탐색하지 않아야함!
		//앞은 start증가 
		for(int j = 0 ; j < 100 ; j++ ) {
			start = 0;
			int x = j;
			if(arr[start][x] == 1) {
				while(start<99) {
					//직진상태인지 좌 우 방향 상태인지 확인해야함
					if(direction == 0) {
						//직진 상태면 좌우 탐색
						if(x-1>=0 && arr[start][x-1]==1) {
							//좌 발견
							x--;
							direction = 1;
						}else if(x+1<=99 && arr[start][x+1]==1) {
							//우 발견
							x++;
							direction = 2;
						}else {
							//좌우없음, 직진
							start++;
						}
					}else if(direction == 1){
						//좌 상태면 좌 탐색
						if(x-1>=0 && arr[start][x-1]==1) {
							//좌 발견
							x--;
						}else {
							start++;
							direction = 0;
						}
					}else if(direction == 2){
						//우 상태면 우 탐색
						if(x+1<=99 && arr[start][x+1]==1) {
							//우 발견
							x++;
						}else {
							start++;
							direction = 0;
						}
					}
				}
				if(arr[99][x] == 2) {
					sb.append("#").append(count).append(" ").append(j).append("\n");
				}
			}
		}
		}
		sc.close();
		System.out.println(sb.toString());
	}

}
