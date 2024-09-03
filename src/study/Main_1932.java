package study;

import java.io.*;
import java.util.*;

public class Main_1932 {
	static int n;
	static long[][] arr;
	
	static boolean indexOk(int r, int c) {
		return  r >=0 &&  r < n  && c >= 0  && c < n*2-1;
	}
	
	static long simul () {
		long ans = 0;
		int star = n-1;
			
		long right = 0;
		long left = 0;
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n*2-1; j++) {
				if(arr[i][j] == 0) continue;
				
				if (arr[i][j] == -1) arr[i][j] = 0;
				
				
				
				if(indexOk(i-1,j-1)) {
					left = arr[i][j] + arr[i-1][j-1];
				}
				if(indexOk(i-1,j+1)) {
					right = arr[i][j] + arr[i-1][j+1];
				}
				
				long max = 0;

				max = Math.max(left, right);
				max = Math.max(max, arr[i][j]);
				
				arr[i][j] = max;
					
				
				ans = Math.max(max, ans);

			}
		}
		
		//for(long[] t  : arr) System.out.println(Arrays.toString(t));
		

		
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int size = n*2-1;
		arr = new long[n][size];
		String str;
		StringTokenizer st;
		
		int star = n-1;
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for (int j = (int) star; j<=star+(i*2); j++) {
				int t = Integer.parseInt(st.nextToken());
				
				if(t==0) t = -1;
				
				arr[i][j] = t;
				
				j++;
			}
			star--;
		}
		
		//for(long[] t : arr) System.out.println(Arrays.toString(t)); 

		long ans = simul();
		System.out.println(ans);

		
	}
}

/*
	    7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5

[0, 0, 0, 0, 7, 0, 0, 0, 0]
[0, 0, 0, 3, 0, 8, 0, 0, 0]
[0, 0, 8, 0, 1, 0, 0, 0, 0]
[0, 2, 0, 7, 0, 4, 0, 4, 0]
[4, 0, 5, 0, 2, 0, 6, 0, 5]

8
9999
9999 9999
9999 9999 9999
9999 9999 9999 9999
9999 9999 9999 9999 9999
9999 9999 9999 9999 9999 9999
0 0 0 0 0 0 0
9999 9999 9999 9999 9999 9999 9999 9999 

  1
 1 1
1 1 1
*/