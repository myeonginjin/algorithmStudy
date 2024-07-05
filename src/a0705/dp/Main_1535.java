package a0705.dp;

import java.util.*;
import java.io.*;

public class Main_1535 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0705/dp/input_1535"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String str;
		StringTokenizer st;
		
		int[] p = new int[n+1];
		int[] w = new int[n+1];
		

		for (int i = 0; i<2; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for (int j = 1; j<=n; j++) {
				if(i==0) w[j] = Integer.parseInt(st.nextToken());
				if(i==1) p[j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[n+1][101];
		
		for (int i = 1; i<=n; i++) {
			
			for (int hp = 0; hp<=100; hp++) {
				if(w[i] >= hp) {
					dp[i][hp] = dp[i-1][hp];
					continue;
				}
				
				if(p[i] + dp[i-1][hp-w[i]] > dp[i-1][hp] ) {
					dp[i][hp] = p[i] + dp[i-1][hp-w[i]];
				} else {
					dp[i][hp] = dp[i-1][hp];
				}
			}
		}
		
		System.out.println(dp[n][100]);
	}

}
