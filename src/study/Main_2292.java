package study;


import java.util.*;

public class Main_2292 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()-1;
		
		int cnt = 1;
		int minus = 6;
		
		while(n>0) {
			n  -= minus;
			cnt++;
			minus+=6;
		}
		System.out.println(cnt);
	}

}
