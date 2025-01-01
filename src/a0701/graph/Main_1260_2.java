package a0701.graph;

import java.util.*;

public class Main_1260_2 {
	static ArrayList<Integer>[] g;
	static int n,m,v;
	static boolean[] visit;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		g = new ArrayList[n+1]; for (int i =0; i<=n; i++) g[i] = new ArrayList<>();
		visit = new boolean[n+1];
		
		 for (int i = 0; i<m; i++) {
			 int to = sc.nextInt();
			 int go = sc.nextInt();
			 
			 g[to].add(go);
			 g[go].add(to);
		 }
		 
		 for (ArrayList<Integer> a : g) Collections.sort(a);
			
		 
		 sb = new StringBuilder();
		 
		 sb.append(v+" ");
		 dfs(v);
		 sb.append("\n");
		 
		 visit = new boolean[n+1];
		 bfs(v);
		 
		System.out.print(sb);
	}
	
	static void dfs(int node) {
		visit[node] = true;
		
		for (int i = 0; i<g[node].size(); i++) {
			int nextN = g[node].get(i);
			
			if(!visit[nextN]) {
				sb.append(nextN+" ");
				dfs(nextN);
			}
		}
	}
	
	static void bfs(int str) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(str);
		
		while (!q.isEmpty()) {
			int node = q.poll();
			if(visit[node]) continue;
			
			visit[node] = true;
			sb.append(node+" ");
			
			for (int i = 0; i<g[node].size(); i++) {
				int next = g[node].get(i);
				if(visit[next]) continue;
				
				q.add(next);
			}
			
			
		}
	}

}
