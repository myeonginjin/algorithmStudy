package a0621.combsubs;

import java.util.*;
import java.io.*;


public class Main_14889_정답 {
	static int n;
	static int minDif = Integer.MAX_VALUE;
	static boolean[] v;
	static int[][] arr;
	static List<Integer> link;
	
	static void comb(int index, int str) {
		if(index==n/2) {
//			System.out.println("link :" +link.toString());
			
			
			calculDif();
			
			return;
		}
		
		for (int i = str; i<=n; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			link.add(i);
			
			comb(index+1, i+1);
			
			v[i] = false;
			link.remove(link.size()-1);
			
		}
	}
	
	static void calculDif() {
		int strSum = 0;
		int linkSum = 0;
		
		boolean[] isLink = new boolean[n+1];
		
		for (int i = 0; i<n/2; i++) {
			int ii = link.get(i);
			isLink[ii] = true;
			
			for (int j = 0; j<n/2; j++) {
				if(i==j) continue;
				
				
				
				linkSum += arr[ii-1][link.get(j)-1];
			}
		}
		
//		for (int i = 1; i<=n; i++) {
//			if(!isLink[i]) System.out.print(i+" ");
//		}
//		System.out.println();
		
		
		for (int i = 1; i<=n; i++) {
			if(isLink[i]) continue;
			
			for (int j = 1; j<=n; j++) {
				if(i==j || isLink[j]) continue;
				
				
				strSum += arr[i-1][j-1];
			}
		}

		minDif = Math.min(Math.abs(strSum-linkSum), minDif);
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st; 
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		link = new ArrayList<>();
		v = new boolean[n+1];
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for (int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,1);
		
		System.out.println(minDif);
	}
}
