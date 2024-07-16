package study;

import java.util.*;

public class Main_1259 {
	
	static boolean check(int n) {
		String[] t = Integer.toString(n).split("");
		
		
		for (int i = 0; i<t.length/2; i++) {
			if(!t[i].equals(t[t.length-i-1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			
			String ans = check(n) ? "yes" : "no";
			System.out.println(ans);
		}
	}

}
