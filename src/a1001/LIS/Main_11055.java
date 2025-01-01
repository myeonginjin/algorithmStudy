package a1001.LIS;

import java.util.*;

public class Main_11055 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		for (int i = 1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 1; i<=n; i++) {
			int elm = arr[i];
			dp[i] = elm;
			
			for (int j = 0; j<i; j++) {
				if(arr[j] < elm) {
					dp[i] = Math.max(dp[i], arr[i] + dp[j]);
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.print(dp[n]);
		
	}

}
