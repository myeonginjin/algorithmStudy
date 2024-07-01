package a0701.graph;

import java.util.*;
import java.io.*;

public class Main_1261_인접행열 {
	static int N,m,v;
	static int[][] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int n) {
		visit[n] = true;
		sb.append(n+" ");
		
		//System.out.println(visit[2] +" "+arr[n][2]);
		
		for (int i = 1; i<=N; i++) {
			if(!visit[i] && arr[n][i]!=0) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int n) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.addFirst(n);
		visit[n] = true;
		
		while(!q.isEmpty()) {
			int t = q.pollLast();
			sb.append(t+" ");
			
			for (int i = 1; i<=N; i++) {
				int go = arr[t][i];
				if(visit[i] || go==0) continue;
				visit[i] = true;
				q.addFirst(i);
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
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		

		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int from = Integer.parseInt(st.nextToken());
			int go = Integer.parseInt(st.nextToken());
			
			arr[from][go] = 1;
			arr[go][from] = 1;
		}
		
		//for (int[]t : arr) Arrays.sort(t);
		
		//for (int[]t :arr) System.err.println(Arrays.toString(t));
		
		
		dfs(v);
		sb.append("\n");
		visit = new boolean[N+1];
		bfs(v);
		
		System.out.println(sb);
		//for(List<Integer> a : arr) System.out.println(a.toString());
	}
}
