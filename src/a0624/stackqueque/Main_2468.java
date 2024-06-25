package a0624.stackqueque;

import java.io.*;
import java.util.*;

public class Main_2468 {
	static int n;
	static int[][] arr;
	static boolean[][] v;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int rainHeight;
	static int cnt;
	static ArrayDeque<int[]> dq = new ArrayDeque<>();
	
	static boolean indexOk(int i , int j) {
		return i>=0 && i<n && j>=0 && j<n;
	}
	
	static void dfs(int i , int j) {
		for (int d = 0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(indexOk(ni,nj) && !v[ni][nj] && arr[ni][nj] > rainHeight) {
				v[ni][nj] = true;
				dfs(ni,nj);
			}
		}
	}
	
	static void bfs(int i, int j) {
		
		//방문처리는 무조건 큐에 넣기 전에 하기 !!! 
		v[i][j] = true;
		
		dq.offer(new int[] {i,j});
		
		while (!dq.isEmpty()) {
			int[] ij = dq.poll();
			i = ij[0];
			j = ij[1];
			
			
			
			for (int d = 0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				
				if(indexOk(ni,nj) && !v[ni][nj] && arr[ni][nj] > rainHeight) {
					v[ni][nj] = true;
					dq.offer(new int[] {ni,nj});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str;
			StringTokenizer st;
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			int maxH = 0;
			
			for (int i = 0; i<n; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				for (int j = 0; j<n; j++) {
					int h = Integer.parseInt(st.nextToken());
					arr[i][j] = h;
					maxH = Math.max(maxH, h);
				}
			}
			
			int maxCnt = 0;
			for (int h = 0; h<=maxH; h++) {
				cnt = 0;
				rainHeight = h;
				v = new boolean[n][n];
				
				for (int i = 0; i<n; i++) {
					for(int j = 0; j<n; j++) {
						if(arr[i][j] > rainHeight && !v[i][j]) {
							v[i][j] = true;
							//dfs(i,j);
							bfs(i,j);
							cnt++;
						}
					}
					
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			System.out.println(maxCnt);
	}
}
