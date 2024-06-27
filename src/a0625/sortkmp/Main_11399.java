package a0625.sortkmp;


import java.util.*;
import java.io.*;

public class Main_11399 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> p = new PriorityQueue<>();
		String t = br.readLine();
		StringTokenizer st = new StringTokenizer(t);
		while (n-->0) {
			p.add(Integer.parseInt(st.nextToken()));
		}
		
		int plus = 0;
		int sum = 0;
		while(!p.isEmpty()) {
			int time =  p.poll();
			sum += plus+time;
			plus += time;
		}
		
		System.out.println(sum);
	}
}
