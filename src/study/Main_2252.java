package study;

import java.util.*;
import java.io.*;

public class Main_2252 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] g = new ArrayList[n+1]; for (int i = 1; i<n+1; i++) g[i] = new ArrayList<>();
		int[] degree = new int[n+1];
		degree[0] = -1;
		
		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			g[from].add(to);
			degree[to]++;
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		for (int i = 1; i<=n; i++) {
			if(degree[i] == 0) q.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			int t = q.poll();
			sb.append(t+" ");
			
			
			for (int nei : g[t]) {
				if(--degree[nei] == 0) q.offer(nei);
			}
		}
		
		System.out.println(sb);
		
	}
}
