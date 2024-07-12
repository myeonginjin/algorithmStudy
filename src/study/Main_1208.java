package study;

import java.util.*;
import java.io.*;

public class Main_1208 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int[] a = new int[n];
		for (int i = 0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		
		for (int i = 1; i< 1<<n; i++) {
			long subsetSum = 0;
			for (int j = 0; j<n; j++) {
				if((i & 1<<j) != 0) subsetSum += a[j];
			}
			if(subsetSum==s) cnt++; 
		}
		System.out.println(cnt);
	}

}
