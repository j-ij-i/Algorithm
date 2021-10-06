package com.ssafy.day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2239 {
	static int map[][];
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int [9][9];
		
		for(int x = 0 ; x < 9 ; x++) {
			String str = br.readLine();
			for(int y = 0 ; y< 9 ;y++) {
				map[x][y] = str.charAt(y) - '0';
			}
		}
		dfs(0,0);
	}	

	private static void dfs(int x, int y) {
		if(flag == true) return;
		if(x==9) {
			for(int i = 0 ; i < 9 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			flag =true;
			return;
		}
	//	System.out.println("x: "+x);
	//	System.out.println("y: "+y);
		if(map[x][y] == 0) {
			for(int i = 1 ; i <= 9 ; i++) {
				if(sdk(i,x,y)) {
					map[x][y] = i;
					if(y == 8) dfs(x+1,0);
					else dfs(x,y+1);
					map[x][y] = 0;
				}
			}
		}else {
			if(y == 8) dfs(x+1,0);
			else dfs(x,y+1);
		}
	}



	private static boolean sdk(int i, int x, int y) {
		//가로
		for(int xx = 0 ; xx < 9 ;xx++) {
			if(map[xx][y] == i)
				return false;
		}
		
		for(int yy = 0 ; yy < 9 ;yy++) {
			if(map[x][yy] == i)
				return false;
		}
		
		int startx = 0;
		int starty = 0;
		startx = (x / 3)*3;
		starty = (y / 3)*3;
		
		for(int xx = startx ; xx <= startx+2 ;xx++) {	
			for(int yy= starty ; yy <= starty+2 ; yy++) {
				if(map[xx][yy] == i)
					return false;
			}
		}
		return true;
	}


}
