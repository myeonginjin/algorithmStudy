package study;

import java.util.*;

public class Main_11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int top = 1;
		for (int i = 1; i<=n; i++) {
			top *= i;
		}
		
		int bottom = 1;
		for (int i = 1; i<=n-m; i++) {
			bottom *= i;
		}
		

		for (int i = 1; i<=m; i++) {
			bottom *= i;
		}
		
		System.out.println(top/bottom);
	}
}
