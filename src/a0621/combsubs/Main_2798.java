package a0621.combsubs;

import java.util.*;
import java.io.*;

public class Main_2798 {
	static int n,sum;
	static int[] a;
	static int[] b;
	static boolean[] v;
	static int minDir = Integer.MAX_VALUE;
	static int ansSum = 0;
	
	static void comb(int index , int str) {
		
		if(index == 3) {
			int bSum = 0;
			for(int t:b) bSum += t;
			
			if(minDir > Math.abs(bSum-sum) && bSum <= sum ) {
				minDir =  Math.abs(bSum-sum);
				ansSum = bSum;
			}
			return;
		}
		
	
		for (int i = str; i<n; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[index] = a[i];
			
			comb(index+1,str+1);
			
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
		sum = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		b = new int[3];
		v = new boolean[n];
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		for (int i = 0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0);
		
		System.out.println(ansSum);
		
	}

}
