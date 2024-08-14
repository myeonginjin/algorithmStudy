package study;

import java.io.*;
import java.util.*;

public class Main_15663 {
	static int n;
	static int m;
	static boolean[] v;
	static int[] a;
	static int[] b;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> h = new HashSet<>();
	
	static void perm(int index) {
		
		if(index == m) {
			String str = "";
			for(int t : b) {
				str += String.valueOf(t) + " ";
			}
			if(h.contains(str)) return;
			
			h.add(str);
			sb.append(str).append("\n");
			return;
		}
		
		for (int i = 0; i<n; i++) { 
			if(v[i]) continue;
			
			b[index] = a[i];
			v[i] = true;
			
			perm(index+1);
			
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		
		a = new int[n];
		b = new int[m];
		v = new boolean[n];
	
		
		str = br.readLine();
		st = new StringTokenizer(str);
		for (int i = 0; i<n; i++) {
			int t = Integer.parseInt(st.nextToken());

			a[i] = t;
		}
		
		Arrays.sort(a);
		
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
		
		perm(0);
		System.out.println(sb);
	}
}
