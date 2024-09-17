package a0701.graph;

import java.io.*;
import java.util.*;

public class Main_20040_사이클게임 {
	static int n;
	static int m;
	static List<Integer>[] g;
	static StringBuilder sb = new StringBuilder();
	static int[] u; 
	static int taget;
	static boolean sycle = false;
	
	static int find(int v1) {
		if(v1 == u[v1]) return v1;
		
		return u[v1] = find(u[v1]);
	}
	
	static boolean union(int v1, int v2) {
		int rootV1 = find(v1);
		int rootV2 = find(v2);
		
		if(rootV1 == rootV2) {
			return true;
		} else {
			u[Math.min(rootV1, rootV2)] = Math.max(rootV1, rootV2);
			return false;
		}
		
	}
	
//	static boolean checkCycle(int v1, int v2) {
//		
//		taget = v2;
//		
//		for (int i = 0; i<g[v1].size(); i++) {
//			int nei = g[v1].get(i);
//			
//			if(nei==v1) continue;
//			
//			dfs(nei);
//		}
//		
//		
//	}
//	
//	static void dfs(int node) {
//		
//		
//		for (int i = 0; i<g[node].size(); i++) {
//			int nei = g[node].get(i);
//			
//			if(nei == taget)
//		}
//
//	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		u = new int[n]; for (int i = 0; i<n; i++) u[i] = i;
		
		g = new ArrayList[n]; for (int i = 0; i<n; i++) g[i] = new ArrayList<>();
		
		int ans = 0;
		
		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
				
			if(union(v1,v2)) {
				ans = i + 1;
				break;
			};
			
		}
		
		//System.out.println(Arrays.toString(u));
		System.out.println(ans);
		
	}
}
