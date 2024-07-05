package a0705.dp;

import java.util.Arrays;

public class CoinDpMain {
	public static void main(String[] args) {
		int N = 8;
		int[] dp = new int[N+1];
//		for(int i = 1; i<=N; i++) {
//			int min = Integer.MAX_VALUE;
//			if(i-1>=0 && min > dp[i-1]+1) min=dp[i-1]+1;
//			if(i-4>=0 && min > dp[i-4]+1) min=dp[i-4]+1;
//			if(i-6>=0 && min > dp[i-6]+1) min=dp[i-6]+1;
//			dp[i] = min;
//		}
		int[] coin = {1,4,6};
		Arrays.fill(dp, Integer.MAX_VALUE); dp[0] = 0;
		//for (int i = 1; i<=N; i++) dp[i] = Integer.MAX_VALUE; 위처럼 하든가 이렇게 하든가
		for (int i = 0; i<coin.length; i++) {
			for (int j = coin[i]; j<=N; j++) {
				dp[j] = Math.min(dp[j],dp[j-coin[i]]+1);
			}
		}
		System.out.println(dp[N]);
	}
}
