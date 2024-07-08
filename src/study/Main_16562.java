package study;

import java.util.*;
import java.io.*;

public class Main_16562 {
	static int n;
	static int[] w;
	static int[] un;
	static int[] rootMinW;
	
	static int find(int v) {
		if(v==un[v]) return v;
		
		return un[v] = find(un[v]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA!=rootB) {
			if (w[rootA] <= w[rootB]) {
				un[rootB] = rootA;
			} else un[rootA] = rootB;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		st = new StringTokenizer(str);
		w = new int[n+1]; for (int i = 1; i<=n; i++) w[i] = Integer.parseInt(st.nextToken());
		//rootMinW = new int[n+1]; for (int i = 1; i<=n; i++) rootMinW[i] = Integer.MAX_VALUE;
		un = new int[n+1]; for (int i = 1; i<=n; i++) un[i] = i;
		
		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			union(v1,v2);
		}
		
		//System.out.println(Arrays.toString(un));
		
		for (int i = 1; i<=n; i++) find(i); 
		 
		HashSet<Integer> s = new HashSet<>();
		for(int n : un) {
			if (n==0)continue;
			s.add(n);
		}
		int sum = 0;
		for (int n : s) {
			sum += w[n];
		}
		
		if(sum<=k) {
			System.out.println(sum);
		} else {
			System.out.println("Oh no");
		}
		
	}

}
