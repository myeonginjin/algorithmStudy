package study;

import java.io.*;
import java.util.*;

public class alice_3_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ArrayList<String> arr = new ArrayList<>(); for (int i = 0; i<str.length(); i++) arr.add(str.substring(i,i+1));
		ListIterator<String> il = arr.listIterator(arr.size());
		ArrayDeque<String> q = new ArrayDeque<>();
		
		
		String temp = "";
		
		while (il.hasPrevious()) {
			String t = il.previous();
			
			if (t.equals(")")) continue;
			
			else if (t.equals("(")) {
				if(il.hasPrevious()) {
					int cnt = Integer.parseInt(il.previous());
					String word = "";
					
					while(!q.isEmpty()) {
						word += q.pollFirst();
					}
					
					String ans = "";
					while(cnt --> 0) ans += word;
					
					q.offerFirst(ans);
				}
				
			}
			
			else {
				q.offerFirst(t);
			}
		}
		
		int anslength = 0;
		
		while(!q.isEmpty()) {
			anslength += q.poll().length();
		}
		
		System.out.println(anslength);
		
	}
}


/*
 *      11(18(72(7)))
 */