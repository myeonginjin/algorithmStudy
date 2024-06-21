package a0621.combsubs;

import java.util.*;
import java.io.*;

public class Main_15650 {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static boolean[] v;
	static int[] b;
	
	static void comb(int index , int str) {
		if(index == m) {
			for(int t :b) sb.append(t+" ");
			sb.append("\n");
			return;
		}
		
		
		for (int i = str; i<=n; i++) {
			if (v[i]) continue;
			b[index] = i;
			v[i] = true;
			
			//아래 처럼하면 안됨. 트리 그려보고 프린트 찍어봐서 왜 안되는지 파악해보기
//			System.out.println(index+1 +" "+ (str+1)+" ");
//			comb(index+1,str+1);
			
			//System.out.println(index+1 +" "+ (i+1)+" "); 트리 그려볼 수 있음
			comb(index+1,i+1);
			
			
			v[i]= false;
			
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str; 
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		b = new int[m];
		v = new boolean[n+1];
		
		comb(0,1);
		
		System.out.println(sb);
		br.close();


	}

}
