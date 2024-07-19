package study;

import java.util.*;

public class Main_15654 {
	static int n,m;
	static int[] a;
	static int[] b;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	
	static void perm(int index) {
		if(index == m) {
			for(int i : b) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i<n; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[index] = a[i];
			
			perm(index+1);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		a = new int[n];
		b = new int[m];
		v = new boolean[n];
		
		
		for (int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		perm(0);
		
		System.out.println(sb);
	}

}
