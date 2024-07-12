package study;


import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class Main_1766 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Integer>[] g = new List[n+1]; for (int i = 1; i<n+1; i++) g[i] = new ArrayList<>();
		int[] degree = new int[n+1];
		
		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			degree[to]++;
		}
		
		for (int i = 1; i<=n; i++) {
			if(degree[i]==0) pq.offer(i); 
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int v = pq.poll();
			sb.append(v).append(" ");
			
			for(int t : g[v]) if(--degree[t]==0) pq.offer(t);
		}
		
		System.out.println(sb);
		br.close();
	}

}
