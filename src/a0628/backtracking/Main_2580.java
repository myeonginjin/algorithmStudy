package a0628.backtracking;


import java.util.*;
import java.io.*;

public class Main_2580 {
	static int[][] arr = new int[9][9];
	static final int ansSum = 45;
	
	static boolean check(int r, int c, int n) {
		
		
		
		//int sum =0;
		
		//행체크
		for(int i = 0; i<9; i++) {
			if(n== arr[i][c]) return false; 
		}
		
		//if(r==5 && c==6) System.out.println(n);
		
		//sum = 0;
		//열체크
		for (int j = 0; j<9; j++) {
			if(n== arr[r][j]) return false;
		}
		
		
		//3*3격자 체크
		int sC = -1;
		int sR = -1;
		
		switch (r) {
		case 0 : case 1 : case 2 :
			sR = 0;
			break;
		case 3 : case 4 : case 5 :
			sR = 3;
			break;
		case 6 : case 7 : case 8 :
			sR = 6;
			break;
		}
		
		
		
		
		switch (c) {
		case 0 : case 1 : case 2 :
			sC = 0;
			break;
		case 3 : case 4 : case 5 :
			sC = 3;
			break;
		case 6 : case 7 : case 8 :
			sC = 6;
			break;
		}
		
		
		
		for (int i = sR; i<sR+3; i++) {
			for (int j = sC; j<sC+3; j++) {
				if(n== arr[i][j]) return false;
			}
		}
		
		return true;
	}
	
	static void back(int r, int c, int n) {
		if(n>9) return;
		
		if(check(r,c,n)) {
			arr[r][c] = n; 
			return;
		}
		back(r,c,n+1);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_2580"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		for (int i = 0; i<9; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i<9; i++) {
			for (int j = 0; j<9; j++) {
				if(arr[i][j]==0) back(i,j, 1);
			}
		}
		
		for(int[] a : arr) {
			for(int t : a) System.out.print(t+" ");
			System.out.println();
		}
		
	}

}
