package study;

import java.io.*;
import java.util.*;

public class Main_11725 {
	static int n;
	static int[] u;
	
	static void union(int v1, int v2) {
		int r1 = find(v1);
		int r2 = find(v2);
		
		if(r1!=r2) u[r2] = r1;
	}
	
	static int find(int v) {
		if(u[v] == v) return v;
		
		return u[v] = find(u[v]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		u = new int[n+1]; for (int i = 1; i<=n; i++) u[i] = i;
		
		for (int i = 0; i<n-1; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			union(v1,v2);
		}
		System.out.println(Arrays.toString(u));
		for (int i = 2; i<=n; i++) {
			find(i);
			System.out.println(u[i]);
		}
		
		
	}

}
