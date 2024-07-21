package study;

import java.util.*;

public class Main_15652 {
	static int n,m;
	static int[] b;
	static boolean[] v;
	
	static void comb(int index, int str) {
		if(index == m) {
			for (int t :b) System.out.print(t+" ");
			System.out.println();
			return;
		}
		
		for (int i = str; i<=n; i++) {
			
			b[index] = i;
			comb(index+1, i);
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = new boolean[n+1];
		b = new int[m];
		
		comb(0,1);
	}

}
