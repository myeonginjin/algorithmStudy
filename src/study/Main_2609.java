package study;

import java.util.*;

public class Main_2609 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int r = Math.min(n, m);
		
		int max = 0;
		
		for (int i = 1; i<=r; i++) {
			if(n%i==0 && m%i==0) max = i;
		}
		
		int min = 0;
		for (int i = 1; i<=Integer.MAX_VALUE; i++) {
			int t = max * i;
			if(t%n==0 && t%m==0) {
				
				min = t;
				break;
			}
		}
		System.out.println(max+"\n"+min);
	}

}
