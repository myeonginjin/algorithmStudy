package study;

import java.util.*;
import java.io.*;



public class Main_11055 {
	static int[][] ips;
	static int[] ansIps;
	static int[] ansMask;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		
		n = Integer.parseInt(br.readLine());
		
		
		
		ips = new int[n][4];
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, ".");
			
			for (int j = 0; j<4; j++) {
				ips[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		ansIps = new int[4];
//		for (int i = 0; i<n; i++) {
//			for (int j = 0; j<4; j++) {
//				ansIps[i][j] = 0;
//			}
//		}
		
		for (int i = 0; i<4; i++) {
			ansIps[i] = ips[0][i];
		}
		
		//ip주소 만들기
		for (int i = 0; i<4; i++) {
			for (int j = 1; j<n; j++) {
				check(i, j);
			}
		}
		
		for(int i = 0; i<ansIps.length; i++) {
			sb.append(ansIps[i]);
			if(i!=ansIps.length-1) sb.append(".");
		}
		sb.append("\n");
		
		//System.out.println(Arrays.toString(ansIps));
		
		ansMask = new int[4];
		for (int i = 0; i<4; i++) {
			ansIps[i] = ips[0][i];
		}
		//ip마스 만들기
		checkMask();	
		
		for(int i = 0; i<ansMask.length; i++) {
			sb.append(ansMask[i]);
			if(i!=ansMask.length-1) sb.append(".");
		}
		
		
		
		//System.out.println(Arrays.toString(ansMask));
		
		System.out.println(sb);
	}
	
	static void check(int c , int r) {
		int temp = (ips[r][c] & ansIps[c]);
		ansIps[c] = temp;
	}
	
	static void checkMask() {
		boolean[] v = new boolean[32];
		
		for (int c = 0 ; c<4; c++) {
			int temp = ips[0][c];
			//boolean same = true;
			
			
			for (int r = 1; r<n; r++) {
				if(temp != ips[r][c]) {
					//same = false;
					
					int ten = temp ^ ips[r][c];
					String two = Integer.toBinaryString(ten);
					int index = 0;
					
					for (int i = v.length - two.length(); i<v.length; i++) {
						if(two.substring(index, index+1).equals("1")) {
							v[i] = true;
						}
						index++;
					}
					
					temp = ips[r][c];
				}
			}
			//if(same) ansMask[c] = 255;
		}
		int index = 0;
		for (int i = 0; i<32; i+=8) {
			String two = "";
			
			for (int j = i; j<i+8; j++) {
				if(!v[j]) two += "1";
				else two += "0";
			}
			int ten = Integer.parseInt(two , 2);
			ansMask[index++] = ten;
		}
	}

}
