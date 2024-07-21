package study;

import java.util.*;

public class Main_15650 {
	static int n , m; 
	static int[] b;
	static boolean[] v;
	
	
	static void com(int index, int str) {
		if(index == m) {
			for(int t : b) System.out.print(t+" ");
			System.out.println();
			return;
		}
		
		for (int i = str; i<=n; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[index] = i;
			
			com(index+1, i+1);
			
			v[i] = false;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		b = new int[m];
		v = new boolean[n+1];
		
		com(0,1);
		
	}

}
