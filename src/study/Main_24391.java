package study;

import java.io.*;
import java.util.*;

public class Main_24391 {
	static int[] a;
	
	static int find(int e) {
		if(a[e] == e) return e;
		
		int root = find(a[e]);
		
		return a[e] = root;
	}
	
	static void union(int e1, int e2) {
		int e1R = find(e1);
		int e2R = find(e2);
		
		if(e1R == e2R) return;
		
		a[e2R] = e1R;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		a = new int[n+1]; for (int i = 1; i<=n; i++) a[i] = i;

		
		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int e1 = Integer.parseInt(st.nextToken());
			int e2 = Integer.parseInt(st.nextToken());
			
			union(e1,e2);
		}
		
		int cnt = 0;
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int preClass = Integer.parseInt(st.nextToken());
		
		
		
		for (int i = 1; i<=n; i++) find(i);
		
		//System.out.println(Arrays.toString(a));
		
		for (int i = 1; i<n; i++) {
			int curClass = Integer.parseInt(st.nextToken());
			if(a[preClass] != a[curClass] )cnt++;
			preClass = curClass;
		}
		System.out.println(cnt);
		br.close();
		
	}

}
