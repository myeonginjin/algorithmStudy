package a0916.dxdy;

import java.util.*;
import java.io.*;


class ChickLocation {
	int r;
	int c;
	
	public ChickLocation(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
}

public class Main_15686_치킨배달 {
	static int n,m;
	static int[][] arr;
	static List<ChickLocation> chickList = new ArrayList<>();
	static List<int[]> homeList = new ArrayList<>();
	static int removeChicNum;
	static boolean[] v;
	static HashSet<Integer> b;
	static int minDis = Integer.MAX_VALUE;
	
	static boolean indexOk(int r, int c) {
		return r>=0 && r < n && c >= 0 && c < n;
	}
	
	static void checkDisSum() {
		int disSum = 0;
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		
		for (int i = 0; i<homeList.size(); i++) {
			int[] t = homeList.get(i);
			int ansDis = Integer.MAX_VALUE;
			
			
			for (int j = 0; j<chickList.size(); j++) {
				
				if(b.contains(j)) continue;
				
				ChickLocation chick = chickList.get(j);
				int dis = Math.abs(chick.r - t[0]) + Math.abs(chick.c - t[1]); 
				
				ansDis = Math.min(ansDis, dis);
			}
			
			
			
			
			disSum += ansDis;
			
		}
		
		
		minDis = Math.min(minDis, disSum);
	}
	
	
	static void comb(int index, int str) {
		if(index == removeChicNum) {
			
			
			checkDisSum();
			

			
			return;
			
		}
		
		for (int i = str; i<chickList.size(); i++) {
			if(v[i]) continue;
			
			v[i] = true;
			b.add(i);
			
			comb(index+1, i+1);
			
			v[i] = false;
			b.remove(i);
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		
		
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for (int j = 0; j<n; j++) {
				int t = Integer.parseInt(st.nextToken());
				arr[i][j] = t;
				
				if(t == 2) {
					ChickLocation temp = new ChickLocation(i, j);
					chickList.add(temp);
				} else if (t == 1) {
					homeList.add(new int[] {i,j});
				}
			}
		}
		
		removeChicNum = chickList.size() - m;
		
	
		v = new boolean[chickList.size()];
		b = new HashSet<>();
		
		comb(0, 0);
		System.out.println(minDis);
		
		
	}
}
