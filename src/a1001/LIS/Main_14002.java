package a1001.LIS;

import java.util.*;

public class Main_14002 {
	
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
			
			for (int j = 0; j<i; j++) {
				if(elm > arr[j]) dp[i] = Math.max(dp[i], dp[j] +1);
			}
		}
		
		int maxN = -1;
		int index = -1;
		
		for (int i = 1; i<=n; i++) {
			if( maxN < dp[i]) {
				maxN = dp[i];
				index = i;
			}
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		int preN = dp[index];
		q.addFirst(arr[index]);
		
		for (int i = index-1; i>=1; i--) {
			if(preN -1 == dp[i]) {
				preN--;
				q.addFirst(arr[i]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(maxN).append("\n");
		for (int t : q) sb.append(t+" ");
		System.out.print(sb);
	}

}
