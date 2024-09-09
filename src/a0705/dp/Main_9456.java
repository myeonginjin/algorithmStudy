package a0705.dp;


import java.util.*;
import java.io.*;


public class Main_9456 {
	
	static int goDP(int n , int[][] arr) {
		int ans = 0;
		
		int[][] dp = new int[2][n];
		
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		
			
		
		for (int i = 1; i<n; i++) {
			
			
			if(i < 2) {
				dp[0][1] = arr[1][0] + arr[0][1];
				dp[1][1] = arr[0][0] + arr[1][1];
				
				continue;
			}
			
			dp[0][i] = Math.max( dp[1][i-1] , dp[1][i-2]) + arr[0][i];
			dp[1][i] = Math.max( dp[0][i-1] , dp[0][i-2]) + arr[1][i];
			
		}
		
		return Math.max(dp[0][n-1], dp[1][n-1]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		String str;
		StringTokenizer st;
		int n;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j<n; j++) {
				arr[0][j] = Integer.parseInt(st.nextToken()); 
			}
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j<n; j++) {
				arr[1][j] = Integer.parseInt(st.nextToken()); 
			}
			
			sb.append(goDP(n, arr)).append("\n");
		
			
		}
		System.out.println(sb);
		
	}

}
