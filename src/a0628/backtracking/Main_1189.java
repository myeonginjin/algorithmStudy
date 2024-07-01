package a0628.backtracking;

import java.util.*;
import java.io.*;

public class Main_1189 {
	static int R,C,k;
	static int[][] a;
	static boolean[][] v;
	static int cnt = 0;
	
	static boolean indexOk(int r, int c) {
		return r>=0 && r < R && c>=0 && c < C; 
	}
	
	
	static void dfs (int r, int c, int dis) {
		if(r==0 && c==C-1) {
			//System.out.println(r+" "+c+" "+dis);
			
//			System.out.println("dis : " +dis);
//			for (boolean[] t : v) {
//				for (int i = 0; i<C; i++) {
//					char temp = t[i] ? 'v' : 'x';
//					System.out.print(temp+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println();
			
			if (dis == k) cnt++;
			return;
		}
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for (int i = 0; i<4; i++) {
			int nextR = r + dx[i];
			int nextC = c + dy[i];
			
			if(indexOk(nextR,nextC) && !v[nextR][nextC] && a[nextR][nextC]!= 1) {
				v[nextR][nextC] = true;
				dfs(nextR, nextC, dis+1);
				
				v[nextR][nextC] = false;
			}
		}
	}
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[R][C];
		v = new boolean[R][C];
		
		for (int i = 0; i<R; i++) {
			str = br.readLine();
			for (int j = 0; j<C; j++) {
				int elm = str.substring(j,j+1).charAt(0) == 'T' ? 1 : 0;
				a[i][j] = elm;
			}

		}
		
		//for (int[] t : a) System.out.println(Arrays.toString(t));
		a[R-1][0] = 1;
		dfs(R-1,0,1);
		System.out.println(cnt);
	}

}
