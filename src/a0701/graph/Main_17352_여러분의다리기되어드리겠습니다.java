package a0701.graph;

import java.util.*;
import java.io.*;


public class Main_17352_여러분의다리기되어드리겠습니다 {
	static int n;
	static int[] u;
	
	
	static int find(int node) {
		if(u[node] == node) return node;
		
		return u[node] = find(u[node]);
	}
	
	static void unoin(int n1, int n2) {
		int root1 = find(n1);
		int root2 = find(n2);
		
		if(root1==root2) return;
		
		else {
			u[Math.max(root1, root2)] = Math.min(root1, root2);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		String str;
		StringTokenizer st;
		
		u = new int[n+1]; for (int i = 1; i<=n; i++) u[i] = i;
		
		for (int i = 0; i<n-2; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			unoin(n1, n2);
		}
		
		HashSet<Integer> hs = new HashSet<>();
		
		
		for (int i = 1; i<u.length; i++) {
			find(i);
			hs.add(u[i]);
		}
		
		
		for(int t : hs) System.out.print(t+" ");
	}
}
