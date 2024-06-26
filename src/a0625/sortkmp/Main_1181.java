package a0625.sortkmp;

import java.util.*;
import java.io.*;

public class Main_1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		HashSet<String> s = new HashSet<>();
		
		for (int i = 0; i<n; i++) {
			String elm = br.readLine();
			
			if(!s.contains(elm)) s.add(elm);
		}
		
		List<String> arr = new ArrayList<>(s);
		
		Collections.sort(arr , (o1,o2) -> {
			if(o1.length()==o2.length()) return o1.compareTo(o2);
			return o1.length() - o2.length();
		});
		
		
		for(String t : arr) System.out.println(t);
	}
}
