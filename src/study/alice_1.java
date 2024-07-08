package study;

import java.io.*;
import java.util.*;

public class alice_1 {
	static int[] a;
	static int[] b;
	static int n;
	static int origin;
	static boolean v[];
	static int minN = Integer.MAX_VALUE;
	
	static void perm(int index) {
		if(index == n) {
			String temp = "";
			for (int i = 0; i<n; i++) {
				temp += Integer.toString(b[i]);
			}
			int num = Integer.parseInt(temp);
			
			if(num <= origin) return;
			minN = Math.min(num, minN);
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
		String str = br.readLine();
		origin = Integer.parseInt(str);
		n = str.length();
		a = new int[n];
		b = new int[n];
		v = new boolean[n];
		
		for (int i = 0; i<n; i++) {
			a[i]  = Integer.parseInt(str.substring(i,i+1));
		}
		
		perm(0);
		System.out.println(minN);
	}
}
