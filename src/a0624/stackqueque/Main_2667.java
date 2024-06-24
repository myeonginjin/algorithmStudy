package a0624.stackqueque;

import java.util.*;
import java.io.*;


public class Main_2667 {
	static int n;
	static int[][] arr;
	static boolean[][] v;
	static ArrayList<Integer> a = new ArrayList<>();
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,-1,1};
	static int cnt;
	
	static boolean indexOk(int i , int j) {
		return i>=0 && i<n && j>= 0 && j < n;
	}
	
	static int dfs (int i, int j) {
		int num = 1;
		v[i][j] = true;
		
		for (int d = 0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(indexOk(ni,nj) && !v[ni][nj] && arr[ni][nj]==1) {
				num += dfs(ni,nj);
			}
		}
		
		return num;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		v = new boolean[n][n];
		cnt = 0;
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();

			for (int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(str.substring(j,j+1));
			}
		}
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				if(!v[i][j] && arr[i][j] == 1) {
					cnt++;
					a.add(dfs(i,j));
				}
			}
		}
		
		Collections.sort(a);
		System.out.println(cnt);
		for (int i = 0; i<a.size(); i++) {
			System.out.println(a.get(i));
		}
		
	}

}
