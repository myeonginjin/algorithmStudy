package study;

import java.util.*;

public class Main_1978 {
	
	static boolean sosu (int t) {
		if(t == 1) return false;
		for (int i = 2; i<t; i++) {
			if(t%i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i<n; i++) {
			if(sosu(sc.nextInt())) cnt++;
		}
		
		System.out.println(cnt);
	}
}
