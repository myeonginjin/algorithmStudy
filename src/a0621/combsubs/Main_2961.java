package a0621.combsubs;

import java.util.*;
import java.io.*;

public class Main_2961 {
	static int n;
	static int[][] a;
	static boolean[] visit;
	static int minDif = Integer.MAX_VALUE;
	
	public static void subCom(int index, int sour, int solt) {
		
		if(index == n) {
			if(sour==1 && solt == 0) return;
			
			//System.out.println(sour +" "+solt);
			
			
			minDif = Math.min(Math.abs(sour-solt), minDif);
			
			return;
		}
		
		//index번째 재료 선택
		subCom(index+1, sour * a[index][0], solt + a[index][1]);
		
		
	
		//선택 안함
		subCom(index+1, sour, solt);
	}
	

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/test2961"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		
		n = Integer.parseInt(br.readLine());
		a = new int[n][2];
		visit = new boolean[n];
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		subCom(0,1,0);
		
		System.out.println(minDif);
		
		
	}
}
