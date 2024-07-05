package a0705.dp;

import java.util.*;
import java.io.*;

public class Main_12865 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] p = new int[n+1];
		int[] w = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		
		for (int i = 1; i<=n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			w[i] = weight;
			p[i] = price;
		}
		
		for (int i = 1; i<=n; i++) {
			for (int j = 1; j<=k; j++) {
				if(w[i] > j) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				
				if(p[i] + dp[i-1][j-w[i]] > dp[i-1][j]) {
					dp[i][j] = p[i] + dp[i-1][j-w[i]];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
