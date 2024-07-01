package a0701.graph;

import java.util.*;
import java.io.*;

public class Main_2606 {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[] v;
	static int cnt = 0;
	
	static void dfs (int node) {
		v[node] = true;
		
		for (int i = 1; i<=N; i++) {
			if(arr[node][i]!=0 && !v[i]) {
				cnt++;
				dfs(i);
			}
		}
	}
	
	static void bfs (int node) {
		v[node] = true;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.addFirst(node);
		
		while(!dq.isEmpty()) {
			int temp = dq.pollLast();
			
			for (int i = 1; i<=N; i++) {
				if(!v[i] && arr[temp][i] != 0) {
					cnt++;
					v[i] = true;
					dq.offerFirst(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		v = new boolean[N+1];
		
		for (int i = 0; i<M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int go = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			
			arr[go][from] = 1;
			arr[from][go] = 1;
		}
		//dfs(1);
		bfs(1);
		
		System.out.println(cnt);
	}

}
