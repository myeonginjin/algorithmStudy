package study;

import java.io.*;
import java.util.*;

public class Main_1764 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<>();
		
		for (int i = 0; i<n; i++) {
			hs.add(br.readLine());
		}
		int cnt = 0;
		PriorityQueue<String> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<m; i ++) {
			str = br.readLine();
			if(hs.contains(str)){
				cnt++; 
				q.add(str);
			}
		}
		System.out.println(cnt);
		
		while(!q.isEmpty()) {
			sb.append(q.poll()).append("\n");
		}
		System.out.println(sb);
	}

}
