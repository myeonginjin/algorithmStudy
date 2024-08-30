package study;

import java.io.*;
import java.util.*;

public class Main_1149 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str;
		StringTokenizer st;
		
		int[][] dp = new int[n+1][3];
		
		for (int i = 1; i<=n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dp[i][0] = Math.min(dp[i-1][1] + r, dp[i-1][2]+ r); 
			dp[i][1] = Math.min(dp[i-1][0] + g, dp[i-1][2]+ g);
			dp[i][2] = Math.min(dp[i-1][0] + b, dp[i-1][1]+ b); 
		}
		
		int min = Math.min(dp[n][0], dp[n][1]);
		min = Math.min(min, dp[n][2]);
		System.out.println(min);
	}

}
