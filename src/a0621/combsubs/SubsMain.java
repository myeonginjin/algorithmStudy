package a0621.combsubs;

import java.io.*;
import java.util.*;



public class SubsMain {
	static int N=4,/* R=3*/ C=0;
	static int[] a= {1,2,3,4}/*, b = new int[R]*/;
	//static boolean[] v = new boolean[N]; 
	
	
	
	// 부분집합 요즘 트랜드
	static void subs(int cnt, String str) {
		if(cnt == N) {
			//System.out.println(Arrays.toString(v)); 
			System.out.println(str); C++;
			return;
		}
		//선택
		subs(cnt+1, str+a[cnt]);
		//비선택
		subs(cnt+1, str+"x");
		
		
	}
	
	public static void main(String[] args) throws Exception {
		C = 0;
		subs(0,"");
		System.out.println(C);
		
	}
	
	
	
	
	
	
	
	
	
	/* 기본 타입 부분집합
	static void subs(int cnt) {
		if(cnt == N) {
			//System.out.println(Arrays.toString(v)); 
			for (int i = 0; i<N; i++) System.out.print((v[i]? a[i]: "x")+" "); C++;
			System.out.println();
			return;
		}
		
		v[cnt] = true; // 선택
		subs(cnt+1);
		
		v[cnt] = false; //비선택
		subs(cnt+1);
		
		
	}
	
	public static void main(String[] args) throws Exception {
		C = 0;
		subs(0);
		System.out.println(C);
		
	}
	*/

}
