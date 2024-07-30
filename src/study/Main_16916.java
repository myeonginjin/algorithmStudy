package study;

import java.util.*;

public class Main_16916 {
	static String parents;
	static String pattern;
	
	static int[] makeTable(String str) {
		int[] t = new int[pattern.length()];
		
		int idx = 0;
		
		for (int i = 1; i<pattern.length(); i++) {
			
			while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = t[idx-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				idx++;
				t[i] = idx;
			}
			
		}
		
		return t;
	}
	
	static boolean kmp (String parents, String pattern) {
		
		
		int[] t = makeTable(pattern);
		int idx = 0;
		
		//System.out.println(Arrays.toString(t));
		
		for (int i = 0; i<parents.length(); i++) {
			
			
			
			//패턴과의 시작점을 찾다가 불일치하기 시작
			while(idx>0 && parents.charAt(i)!=pattern.charAt(idx)) {
				idx = t[idx-1];
			}
			
			//패턴과 일치한 시작점을 찾았음
			if(parents.charAt(i)==pattern.charAt(idx)) {
				
				//패턴의 전체 문자와 동일함 
				if(idx == pattern.length()-1) {
					return true;
				} else {
					idx++;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		parents = sc.next();
		pattern = sc.next();
		
		int ans = kmp(parents, pattern) ? 1 : 0;
		
		System.out.println(ans);
	}

}
