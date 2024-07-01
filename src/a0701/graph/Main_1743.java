package a0701.graph;


import java.io.*;
import java.util.*;

public class Main_1743 {
	static int N,M,K;
	static boolean v[][];
	static int[][] arr;
	static int cnt = 1;
	
	static boolean indexOk(int r, int c) {
		return r>=0 && r<N && c>=0 && c < M;
	}
	
	static void dfs(int r, int c) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for (int i = 0; i<4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(indexOk(nr,nc) && arr[nr][nc]==1) {
				if(v[nr][nc]) continue;
				v[nr][nc] = true;
				cnt++;
				
				dfs(nr,nc);
				v[nr][nc] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		v = new boolean[N][M];
		//ArrayList<int[]> point = new ArrayList<>();
		
		for (int i = 0; i<K; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r-1][c-1] = 1;
			//point.add(new int[] {r-1,c-1});
		}
		
		int maxCnt = Integer.MIN_VALUE;
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<M; j++) {
				if(!v[i][j] && arr[i][j] == 1) {
					v[i][j] = true;
					dfs(i,j);
					
					maxCnt = Math.max(maxCnt, cnt);
					cnt = 1;
				}
			}

		}
		
		System.out.println(maxCnt);
		
		
	}
}
