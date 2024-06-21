package a0621.combsubs;

import java.io.*;
import java.util.*;



// 6월 21일 시험보는 내용
// 순연 만들기


// 이 문제는 4C3 조합 문제 

public class CombMain {
	static int N=4, R=3, C=0;
	static int[] a= {1,2,3,4}, b = new int[R];
	//static boolean[] v = new boolean[N]; 필없
	
	static void comb(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(b)); C++;
			return;
		}
		for(int i = start; i<N; i++) {
			b[cnt] = a[i];
			comb(cnt+1, i+1);   //만약 여기가 comb(cnt+1,i); 라면 중복을 허용하는 조합이 됨 !! 중복조합 
			 
		}
	}
	
	public static void main(String[] args) throws Exception {
		C = 0;
		comb(0,0);
		System.out.println(C);
		
	}

}
