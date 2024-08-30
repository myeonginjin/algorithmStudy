package study;

import java.util.*;
import java.io.*;

public class Main_1629 {
	
	static long recur (int a, int b, int c) {
		if(b <= 1) {
			return a % c;
		}
		
		long half = recur(a, b / 2, c);
			
		if(b % 2 == 1) {
			return  (  (half * half % c) * (a%c)  ) % c;
		}
		
	
		return (half * half) % c;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(recur(a,b,c));

		
	}

}
