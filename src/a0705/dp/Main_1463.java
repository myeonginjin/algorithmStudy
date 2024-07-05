package a0705.dp;

import java.util.*;
import java.io.*;

public class Main_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int n = sc.nextInt();
		
		int size = n<=4 ? 4 : n;
		int[] dp = new int[size+1];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		
		
		for (int i = 5; i<=n; i++) {
			int t1 = i%3==0 ? dp[i/3] : Integer.MAX_VALUE;
			int t2 = i%2==0 ? dp[i/2] : Integer.MAX_VALUE;
			int t3 = dp[i-1];
			
			t1 = Math.min(t1, t2);
			t1 = Math.min(t1, t3);
			dp[i] = t1+1;
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
		
	}
}
