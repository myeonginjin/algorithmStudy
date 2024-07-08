package study;

import java.awt.geom.Area;
import java.io.*;
import java.time.zone.ZoneOffsetTransitionRule;
import java.util.*;

public class Main_14502 {
	static int n,m;
	static int[][] arr;
	static int[][] test;
	//static boolean[][] v; 
	static List<int[]> twoPoint = new ArrayList<>();
	static int ansCnt = 0;
	
	static boolean indexOk(int r, int c) {
		return r>=0 && r < n && c >= 0 && c < m;
	}
	
	static void cntArea(int[][] a) {
		int[][] cnt = new int[n][m];
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				cnt[i][j] = a[i][j];
			}
		} 
		
		bfs(cnt);
	}
	
	static void bfs(int[][] cnt) {
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,-1,1};
		
		boolean[][] v = new boolean[n][m];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i<twoPoint.size(); i++) {
			int[] t = twoPoint.get(i);
			q.offer(new int[] {t[0],t[1]});
			v[t[0]][t[1]] = true; 
		}
		

		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			
			for (int i = 0; i<4; i++) {
				int nr = t[0] + dr[i];
				int nc = t[1] + dc[i];
				
				if(indexOk(nr,nc) && !v[nr][nc] && cnt[nr][nc] == 0) {
					cnt[nr][nc] = 2;
					v[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		int safeAreaCnt = 0;
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if(cnt[i][j] == 0) safeAreaCnt++;
			}
		}
		
		ansCnt = Math.max(safeAreaCnt, ansCnt);
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/study/input_14502"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		test = new int[n][m];
		List<int[]> zeroPoint = new ArrayList<>();

		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				test[i][j] = num;
				
				if(num==0) zeroPoint.add(new int[] {i,j}); 
				if(num==2) twoPoint.add(new int[] {i,j}); 
			}
		}
		
		for (int i = 0; i<zeroPoint.size()-2; i++) {
			int[] t = zeroPoint.get(i);
			test[t[0]][t[1]] = 1;
			for (int j = i+1; j<zeroPoint.size()-1; j++) {
				int[] tt = zeroPoint.get(j);
				test[tt[0]][tt[1]] = 1;
				for (int k = j+1; k<zeroPoint.size(); k++) {
					int[] ttt = zeroPoint.get(k);
					test[ttt[0]][ttt[1]] = 1;
					
					cntArea(test);
					
					test[ttt[0]][ttt[1]] = 0;
				}
				test[tt[0]][tt[1]] = 0;
			}
			test[t[0]][t[1]] = 0;
		}
		
		System.out.println(ansCnt);
	}
}
