package a0625.listTree;

import java.util.*;
import java.io.*;

public class Main_1406 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1406"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		String str;
		StringTokenizer st;
		ArrayList<String> arr = new ArrayList<>();
		
		
		for (int i = 0; i<word.length(); i++) {
			arr.add(word.substring(i,i+1));
		}
		
		int n = Integer.parseInt(br.readLine());
		
		int p = arr.size();
		
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			String type = st.nextToken();
			String w = type.equals("P") ? st.nextToken() : "";

			
			switch (type) {
			case "L" :
				p = p==0 ? p : p-1;
				break;

			case "D" :
				p = p==arr.size()-1 ? p : p+1;
				break;

			case "B" :
				if(p==0) break;
				arr.remove(p-1);
				p--;
				break;

			case "P" :
				arr.add(p,w);
				p++;
				break;
			}
			
			//System.out.println(arr.toString());
		}
		
		for (String s : arr) System.out.print(s);
		
		
	}

}
