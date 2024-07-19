package study;

import java.util.*;

public class Main_11660 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n][n];
		
		for (int i = 0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			for (int j = 1; j<n; j++) {
				arr[i][j] = sc.nextInt() + arr[i][j-1];
			}
		}
		
		//for (int[] t : arr) System.out.println(Arrays.toString(t)); 
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<m; i++) {
			int x1 = sc.nextInt()-1;
			int y1 = sc.nextInt()-1;
			int x2 = sc.nextInt()-1;
			int y2 = sc.nextInt()-1;
			
			int sum = 0;
			
			for (int r = x1; r<=x2; r++) {
				int t = y1-1>=0 ?  arr[r][y1-1] : 0;
				sum += arr[r][y2] - t;
			}
			
			//sb.append(sum).append("\n");
			System.out.println(sum);
		}
		//System.out.println(sb);
		
		
	}

}
