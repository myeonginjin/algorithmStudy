package a0624.stackqueque;


import java.util.*;
import java.io.*;

public class Main_10773 {
	public static void main(String[] args) throws Exception {
		ArrayDeque<Integer> d = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				d.push(num);
			}
			else {
				d.pop();
			}
			
			//System.out.println(d); 
		}
		
		int sum = 0;

		while(!d.isEmpty()) {
			sum += d.pop();
		}
		
		
		
		System.out.println(sum);
	}
}
