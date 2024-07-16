package study;

import java.io.*;
import java.util.*;

public class Main_30802 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		for (int i = 0; i<6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int ans1 = 0;
		for (int i= 0; i<6; i++) {
			int tt = arr[i] % t == 0 ? arr[i] / t  : (arr[i] / t) +1;
			ans1 +=  tt ;
		}
		
		int ans2 = n / p;
		int ans3 = n % p;
		
		System.out.println(ans1+"\n"+ans2+" "+ans3);
	}
}
