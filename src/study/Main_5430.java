package study;

import java.io.*;
import java.util.*;

public class Main_5430 {
	static StringBuilder sb = new StringBuilder();
	
	static void fx(String t , ArrayDeque<Integer> q) {
		
		boolean reverse = false;
		
		for (int i = 0; i<t.length(); i++) {
			
			String type = t.substring(i,i+1);
			
			if(type.equals("D")) {
				if(q.isEmpty()) {
					sb.append("error").append("\n");
					return;
				}
				
				if(!reverse)q.pollFirst();
				else q.pollLast();
				
			} else {
				reverse = !reverse;
			}
			
		}
		
		if(!reverse) {
			sb.append("[");
			int size = q.size();
			
			while(size-->0) {
				sb.append(q.pollFirst());
				if(size!=0) sb.append(",");
			}
			sb.append("]").append("\n");
		}
		else {
			sb.append("[");
			int size = q.size();
			
			while(size --> 0) {
				sb.append(q.pollLast());
				if(size!=0) sb.append(",");
			}
			sb.append("]").append("\n");
			
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_5430"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String type;
			type = br.readLine();
			int n = Integer.parseInt(br.readLine());
			str = br.readLine();
			


			ArrayDeque<Integer> q = new ArrayDeque<>();
			

				str = str.substring(1, str.length()-1);
				st = new StringTokenizer(str,",");
				
				for (int i = 0; i<n; i++) {
					q.add(Integer.parseInt(st.nextToken()));
				}

			fx(type, q);
			}
		
		System.out.println(sb);
		br.close();
	}

}
