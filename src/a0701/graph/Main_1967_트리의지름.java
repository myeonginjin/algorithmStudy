package a0701.graph;

import java.io.*;
import java.util.*;

class Node {
	int n;
	int d;
	
	public Node(int num , int dis) {
		this.n = num;
		this.d = dis;
	}
}

public class Main_1967_트리의지름 {
	static int n;
	static List<Node>[] g;
	static boolean[] v;
	static long maxDis;
	static int farN;
	
	
	static void dfs (int node, long dis) {
		
		for (int i = 0; i<g[node].size(); i++) {
			
			Node nei = g[node].get(i);
			
			if(!v[nei.n]) {
				
				v[nei.n] = true;
				dfs(nei.n, dis + nei.d);
			}
		}
		
		if (maxDis < dis) {
			maxDis = dis;
			farN = node;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		g = new LinkedList[n+1];
		
		for (int i = 1; i<=n; i++) g[i] = new LinkedList<>(); 
		
		v = new boolean[n+1];
		
		
		String str;
		StringTokenizer st;
		
		for (int i = 0; i<n-1; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int go = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			g[go].add(new Node(to, dis));
			g[to].add(new Node(go, dis));
		}
		
		//for (int[]t  : g) System.out.println(Arrays.toString(t));
		
		v[1] = true;
		dfs(1, 0);
		
		int n1 = farN;
		
		//System.out.println(maxDis + " " +farN);
		
		v = new boolean[n+1];
		maxDis = 0;
		
		dfs(n1, 0);
		
 
		System.out.println(maxDis);
		
	}
}
