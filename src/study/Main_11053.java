package study;

import java.util.*;

public class Main_11053 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		
		for (int i = 1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		
		int[] dp = new int[n+1];
		int ans = Integer.MIN_VALUE;
		//int ans = 1;
		
		//dp[0] = 1;
		for(int i = 1; i<=n; i++) {
			int max = 1;
			for (int j = i-1; j>=0; j--) {
				
				if(a[j] < a[i]) {
					max = Math.max(max, dp[j]+1);
				}
			}
			dp[i] = max;
			ans = Math.max(ans, max);
		}
		
		//for (int i : dp) System.out.print(i+" ");
		
		System.out.println(ans);
	} 

}
