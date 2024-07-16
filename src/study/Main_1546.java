package study;

import java.io.*;
import java.util.*;

public class Main_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n];
		double maxS = Integer.MIN_VALUE;
		for (int i = 0; i<n; i++) {
			int t = sc.nextInt();
			maxS = Math.max(maxS, t);
			s[i] = t;
		}
		
		double sum = 0;

		
		for (int i = 0; i<n; i++) {
			int t = s[i];
			
			double newS = t/maxS*100.0;
			//System.out.println(newS);
			sum += newS;
		}
		
		//System.out.println(sum);
		//System.out.println(maxS+" "+sum);
		
		System.out.println(sum/n);
	}
}
