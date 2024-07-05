package a0705.dp;


import java.io.*;
import java.util.*;

public class Knapsack2Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("scr/a0705/dp/input_knapsack"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for (int i = 0; i<N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		int[][] dp = new int[N+1][W+1];
		for (int i = 1; i<=N; i++) {
			for (int w =1; w<W; w++) {
				if(weights[i]<=w) {
					dp[i][w] = Math.max(dp[i-1][w], profits[i] + dp[i-1][w - weights[i]]);
				} else {
					dp[i][w] = dp[i-1][w];
				}
			}
			
		}
		
		System.out.println(dp[N][W]);
		sc.close();
	}
}


/*
4
10
5 10
4 40
6 30
3 50
*/