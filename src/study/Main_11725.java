package study;

import java.util.*;

public class Main_11725 {
	static int n;
	static List<int[]>[] g;
	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new List[n+1]; for (int i = 1; i<=n; i++) g[i] = new ArrayList<>();
		
		
		for (int i = 0; i<n-1; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			g[v1].add(new int[] {v2,0});
			g[v2].add(new int[] {v1,0});
		}
		
		boolean[] v = new boolean[n+1];
		v[1] = true;
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {1,0});
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int vn = t[0];
			int depth = t[1];
			
			for (int i = 0; i<g[vn].size(); i++) {
				int child = g[vn].get(i)[0];
				if(!v[child]) {
					g[vn].get(i)[1] = depth+1;
					q.offer(new int[] {child, depth+1});
				}
			}
		}
	}
}
