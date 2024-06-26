package a0625.listTree;

import java.util.*;
import java.io.*;

public class Main_1406_정답 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1406"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		String str;
		StringTokenizer st;
		//ArrayList<String> arr = new ArrayList<>();
		LinkedList<Character> arr = new LinkedList<>();
//		
//		for (int i = 0; i<word.length(); i++) {
//			arr.add(word.substring(i,i+1));
//		}
//		
		char[] charr = word.toCharArray();
		
		for(Character c:charr) arr.add(c);
		
		
		
		int n = Integer.parseInt(br.readLine());
		
		//int p = arr.size();
		ListIterator<Character> p = arr.listIterator(arr.size());
		
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			String type = st.nextToken();
			Character w = type.equals("P") ? st.nextToken().charAt(0) : '?';

			
			switch (type) {
			case "L" :
				if(p.hasPrevious()) {
					p.previous();
				}
				break;

			case "D" :
				if(p.hasNext()) {
					p.next();
				}
				break;

			case "B" :
				if(p.hasPrevious()) {
					p.previous();
					p.remove();
				}
				break;

			case "P" :
				p.add(w);
				break;
			}
			
			//System.out.println(arr.toString());
		}
		StringBuilder sb = new StringBuilder();
		
		for (Character s : arr) sb.append(s);
		System.out.print(sb);
		
		
	}

}
