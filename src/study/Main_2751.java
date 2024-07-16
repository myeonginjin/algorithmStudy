package study;

import java.util.*;

public class Main_2751 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i<n; i++) {
			q.offer(sc.nextInt());
		}
		
		for (int i = 0; i<n; i++) {
			sb.append(q.poll()).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
