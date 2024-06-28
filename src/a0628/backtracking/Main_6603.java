package a0628.backtracking;

import java.util.*;
import java.io.*;

public class Main_6603 {
	static int k;
	static int[] arr;
	static int[] ans;
	static boolean[] v;
	static StringBuilder sb;
	
	
	static void com (int index, int str) {
		//가지치기		
		if( 6 - index > k-str) {
			//System.out.println( index +" " + str);	
			return;
		}
		
		if(index==6) {
			for(int t: ans) sb.append(t+" ");
			sb.append("\n");
			return;
		}
		
		for (int i = str; i<k; i++) {
			if(v[i]) continue;
			v[i] = true;
			ans[index] = arr[i];
			
			com(index+1, i+1);
			v[i] = false;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		sb = new StringBuilder();
		
		while (true) {
			str = br.readLine();
			st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken());
			
			if (k==0) break;
			
			arr = new int[k];
			ans = new int[6];
			v = new boolean[k];
			
			for (int i = 0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			com(0,0);
			
			sb.append("\n");
		}
		
		br.close();
		System.out.print(sb);
		
	}

}
