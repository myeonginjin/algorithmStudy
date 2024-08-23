package study;

import java.io.*;
import java.util.*;

public class Main_15666 {
	static int n,m;
	static int[] a;
	static int[] b;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> hs = new HashSet<>();
	
	static void perm(int index) {
		
		if(index == m) {
			String ans = "";
			for (int i = 0; i<m; i++) {
				ans += b[i];
				ans += " ";
			}
			if (hs.contains(ans)) {
				return;
			}
			
			sb.append(ans).append("\n");
			hs.add(ans);
			
			return;
		}
		
		for (int i = 0; i<n; i++) {
			
			if(index!=0) {
				if (b[index-1] > a[i]) continue; 
			}
			
			b[index] = a[i];
			
			perm(index+1);
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
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		for (int i = 0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		perm(0);
		
		System.out.println(sb);
		
	}

}
