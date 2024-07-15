package study;

import java.io.*;
import java.util.*;

public class Main_1927 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i<n; i++) {
			int t = Integer.parseInt(br.readLine());
			
			if(t==0) {
				if(pq.isEmpty()) sb.append("0").append("\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				pq.offer(t);
			}
			
		}
		
		System.out.println(sb);
	} 

}
