package study;

import java.io.*;
import java.util.*;

public class Main_11286 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>( 
				(o1,o2) -> { if (Math.abs(o1)==Math.abs(o2)) return Integer.compare(o1,o2); 
				else  return Math.abs(o1)-Math.abs(o2); }
		) ;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<n; i++) {
			int t = Integer.parseInt(br.readLine());
			if(t==0) {
				if(!pq.isEmpty()) sb.append(pq.poll());
				else sb.append(0);
				sb.append("\n");
			} else {
				pq.add(t);
			}
		}
		//test
		System.out.println(sb);
	}
}
