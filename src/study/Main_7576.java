package study;


import java.*;
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_7576 {
	static int n,m;
	static int[][] arr;
	static boolean[][] v;
	static ArrayDeque<int[]> q = new ArrayDeque<>();
	
	static boolean indexOk(int r , int c) {
		return r>=0 && r<n && c>=0 && c<m;
	}
	
	static int bfs() {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int maxDay = 0;

		
		while(!q.isEmpty()) {
			
			int[] t = q.poll();
			maxDay = Math.max(t[2], maxDay);
			
			for (int i = 0; i<4; i++) {
				int nr = t[0] + dr[i];
				int nc = t[1] + dc[i];
				
				if(indexOk(nr,nc) && arr[nr][nc] == 0) {
					arr[nr][nc] = 1;
					q.offer(new int[]{nr,nc, t[2]+1});
				}
				
			}
		}
		return maxDay;

	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		v = new boolean[n][m];
		
		int zeroCnt = 0;
		

		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);

			
			for (int j = 0; j<m; j++) {
				int t = Integer.parseInt(st.nextToken());
				arr[i][j] = t;
				if(t==1) q.offer(new int[] {i,j,0});
				else if(t==0) zeroCnt++;
 			}
		}

		
		if(zeroCnt==0) {
			System.out.print(0);
			System.exit(0);
		}
		

		
		int day = bfs();
		boolean fail = false;
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if(arr[i][j]==0) fail = true; 
			}
		}
		
		if(fail) {
			System.out.println(-1);
		} else {
			System.out.println(day);
		}
		
	}

}
