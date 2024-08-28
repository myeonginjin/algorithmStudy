package study;

import java.io.*;
import java.util.*;





public class Main_11725 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String str;
		StringTokenizer st;
		
		LinkedList<Integer>[] g = new LinkedList[n+1]; for (int i = 1; i<=n; i++) g[i] = new LinkedList<>();
		
		
		for (int i = 0; i<n-1; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			g[n1].add(n2);
			g[n2].add(n1);
		}
		
		boolean[] v = new boolean[n+1];
		int[] p = new int[n+1];
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		q.add(1);
		v[1] = true;
		
		while(!q.isEmpty()) {
			int t = q.poll();
			//System.out.println(t);
			
			
			for (int c : g[t]) {

				if(v[c]) continue;
				
				v[t] = true;
				p[c] = t;
				q.add(c);
			}
		}
		
		
		for (int i = 2; i<=n; i++) {
			System.out.println(p[i]); 
		}
			
		
	}

}
