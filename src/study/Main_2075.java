package study;

import java.util.*;

public class Main_2075 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int[][] arr = new int[n][n];
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				int elm = sc.nextInt();
				
				if(i>0) {
					int min = q.poll();
					if(min < elm) {
						q.add(elm);
					} else {
						q.add(min);
					}
				} else {
					q.add(elm);
				}
				
				
			}
		}
		
		System.out.println(q.poll());

	}

}
