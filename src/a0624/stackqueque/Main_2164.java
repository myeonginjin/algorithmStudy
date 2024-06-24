package a0624.stackqueque;


import java.util.*;
import java.io.*;

public class Main_2164 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> d = new ArrayDeque<>();
		for (int i = 1; i<=n; i++) {
			d.offer(i);
		}
		int ans = 0;
		while(!d.isEmpty()) {
			ans = d.poll();
			
			if(d.isEmpty()) {
				break;
			}
			
			int num = d.poll();
			d.offer(num);
		}
		
		System.out.println(ans);
	}
}
