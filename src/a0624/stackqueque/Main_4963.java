package a0624.stackqueque;

import java.util.*;
import java.io.*;

public class Main_4963 {
	static int[][] arr;
	static int n,m, cnt;
	static boolean[][] v;
	
	static boolean indexOk(int i , int j) {
		return i>=0 && i<n && j>=0 && j<m;
	}
	
	public static void bfs() {
		ArrayDeque<int[]> d = new ArrayDeque<>();
		
		int[] di = new int[] {-1,-1,0,1,1,1,0,-1};
		int[] dj = new int[] {0,1,1,1,0,-1,-1,-1};
		
		for (int i = 0; i<n; i++) {
			
			for (int j = 0; j<m; j++) {
				if(v[i][j] || arr[i][j] == 0) continue;
				
				//System.out.println(i+" "+j);
				
				d.offer(new int[] {i,j});
				
				while(!d.isEmpty()) {
					
					int[] t = d.poll();
					
					
					for (int s = 0; s<8; s++) {
						int ni = t[0] + di[s];
						int nj = t[1] + dj[s];
						
						if(indexOk(ni,nj) && !v[ni][nj] && arr[ni][nj]==1) {
							d.offer(new int[] {ni,nj});
							v[ni][nj] = true;
						}
					}
				}
				cnt++;
			}
		}

		
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_4963"));
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;

		
	
		while(true) {
			
			str = br.readLine();
			
			st = new StringTokenizer(str);
			
			//System.out.println(st);
			

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			//System.out.println(n+" "+m);
//			
//			
//			
			if(n==0 && m ==0) break;
//			
			arr = new int[n][m];
			v = new boolean[n][m];
//			
//			System.out.println("!");
//			
			for (int i = 0; i<n; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				
				for (int j =0; j<m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			bfs();
			System.out.println(cnt);
		}
	}
}
