package study;

import java.io.*;
import java.util.*;

public class Main_11659 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		int[] origin = new int[n+1];
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		
		for(int i = 1; i<=n; i++) {
			int t = Integer.parseInt(st.nextToken());
			arr[i] = t + arr[i-1];
			origin[i] = t;
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int s = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			if(s==l) {
				sb.append(origin[s]).append("\n");
			}
			else {
				int ans = arr[l] - arr[s-1];
				sb.append(ans).append("\n");
			}
			
		}
		System.out.println(sb);
	}

}
