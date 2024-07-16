package study;

import java.io.*;
import java.util.*;

public class Main_11724 {
	static int n,m;
	static List[] g;
	static int[] u;
	
	static int find (int v) {
		if (u[v]==v) return v;
		
		return u[v] = find(u[v]);
	}
	
	static void union (int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) u[aRoot] = bRoot;
	}
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_11724"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		g = new List[n+1]; for (int i = 1; i<=n; i++) g[i] = new ArrayList<>();
		u = new int[n+1]; for (int i = 1; i<=n; i++) u[i] = i;
		
		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int from = Integer.parseInt(st.nextToken());
			int go = Integer.parseInt(st.nextToken());
			
			union(from, go);
		}

		
		HashSet<Integer> h = new HashSet<>();
		for (int i = 1; i<=n; i++) {
			find(i);
			
			if(!h.contains(u[i])) {
				h.add(u[i]);
			}
		}
		
		//System.out.println(Arrays.toString(u));
		
		System.out.println(h.size());
	}

}
