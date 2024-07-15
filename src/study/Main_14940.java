package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_14940 {
	static int n,m;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_14940"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		str = br.readLine();
		st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		boolean[][] v = new boolean[n][m];
		
		int sr = 0,sc= 0;
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j<m; j++) {
				int  t = Integer.parseInt(st.nextToken());
				arr[i][j] = t;
				if(t==2) {
					sr = i;
					sc = j;
				}
			}
		}
		arr[sr][sc] = 0;
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sr,sc, 0});
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			
			for (int i = 0; i<4; i++) {
				int nr = t[0] + dr[i];
				int nc = t[1] + dc[i];
				
				
				if(indexOk(nr,nc) && arr[nr][nc] == 1 && !v[nr][nc]) {
					v[nr][nc] = true;
					arr[nr][nc] = arr[ t[0] ][ t[1] ] + 1;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if(arr[i][j]==1) {
					
					boolean nei = false;
					
					
					
					for (int k = 0; k<4; k++) {
						if(i == sr+dr[k] && j == sc+dc[k]) nei = true;
					}
					
					if(nei) {

						sb.append(1+" ");  
					}
					else sb.append(-1+" ");
				}
				else sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean indexOk(int r, int c) {
		
		return r>=0 && r < n && c >=0 && c < m;
	}

}
