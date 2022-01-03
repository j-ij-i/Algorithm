import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
	static int start,max,N;
	static int number[];
	static int inning[][];
	static int order[];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		inning = new int[N][9];
		for(int n = 0 ; n < N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 9 ; i++) {
				inning[n][i]= Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[9];
		number = new int[9];
		visited[3] = true;
		number[3] = 0;
		max = Integer.MIN_VALUE;
		permu(1);
		System.out.println(max);
	}

	private static void permu(int cnt) {
		if(cnt == 9) {
			play();
			return;
		}
		for(int x = 0 ; x <= 8 ; x++) {
			if(visited[x]== false) {
				visited[x] = true;
				number[x] = cnt;
				permu(cnt+1);
				visited[x] = false;
			}
		}
	}

	private static void play() {
		int score = 0;
		int outcnt = 0;
		int start = 0;
		boolean field[];
		for(int i = 0 ; i < N ; i++) {
			field= new boolean[4];
			outcnt = 0;
			 while(true) {
//				 System.out.println(number[start]);
				if(inning[i][number[start]] == 0) {
					outcnt++;
					start++;
				}else if(inning[i][number[start]] == 1) {
					for(int j = 3 ; j > 0 ; j--) {
						if(field[j]== true) {
							if(j==3) {
								score++;
								field[j] = false;
							}else {
								field[j+1] = true;
								field[j] = false;
							}
						}
					}
					field[1] = true;
					start++;
				}else if(inning[i][number[start]] == 2) {
					for(int j = 3 ; j > 0 ; j--) {
						if(field[j] == true) {
							if(j==3 || j ==2) {
								score++;
								field[j] = false;
							}else {
								field[j+2] = true;
								field[j] = false;
							}
						}
					}
					start++;
					field[2] = true;
				}else if(inning[i][number[start]] == 3) {
					for(int j = 3 ; j > 0 ; j--) {
						if(field[j] == true) {
							score++;
							field[j] = false;
						}
					}
					start++;
					field[3] = true;
				}else if(inning[i][number[start]] == 4) {
					for(int j = 3 ; j > 0 ; j--) {
						if(field[j]==true) {
							score++;
							field[j] = false;
						}
					}
					start++;
					score++;
				}
				if(start == 9) {
					start = 0;
				}
				if(outcnt == 3) {
					outcnt = 0;
					break;
				}

			}
			
		}
		max = Math.max(max, score);
	}
}
