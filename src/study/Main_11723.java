package study;

import java.util.*;
import java.io.*;

public class Main_11723 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str;
		StringTokenizer st;
		
		HashSet<Integer> h = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			
			switch (st.nextToken()) {
			
			case "add" :
				h.add(Integer.parseInt(st.nextToken()));
				break;
				
			case "check" :
				int t = h.contains(Integer.parseInt(st.nextToken())) ? 1 : 0;
				sb.append(t).append("\n");
				break;
				
			case "toggle" :
				int t1 = Integer.parseInt(st.nextToken());
				if(h.contains(t1)) h.remove(t1);
				else h.add(t1);
				break;
				
			case "all" :
				h.clear();
				for (int s = 1; s<=20; s++) h.add(s); 
				break;
				
			case "empty" :
				h.clear();
				break;
				
			case "remove" :
				int t2 = Integer.parseInt(st.nextToken());
				if(h.contains(t2)) h.remove(t2);
				break;
			}
			
			//System.out.println( (i+1) +" " + h);
			
		}
		System.out.println(sb);
	}
}
