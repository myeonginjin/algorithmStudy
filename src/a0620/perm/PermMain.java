package a0620.perm;


import java.util.*;
import java.io.*;


// 6월 21일 시험보는 내용
// 순연 만들기


public class PermMain {
	static int N=4, R=3, C=0;
	static int[] a= {1,2,3,5}, b = new int[R];
	static boolean[] v = new boolean[N];
	
	public static void perm(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(b)); C++;
			return;
		}
		for(int i = 0; i<N; i++) {
			if(v[i]) continue;
			v[i] = true;  //여기
			//int T = b[cnt];  //이 부분 
			b[cnt] = a[i];
			perm(cnt+1);
			//b[cnt]=T;  // 그리고 이 부분은 필요없음
			v[i] = false; //그리고 여기 주석처리하면 중복을 허용하는 순열
		}
	}
	
	public static void main(String[] args) throws Exception {
		C = 0;
		perm(0);
		System.out.println(C);
		
	}

}
