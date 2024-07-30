package study;

import java.io.*;
import java.util.*;

public class Main_1786 {
	static String t;
	static String p;
	static int cnt;
	
	static StringBuilder kmp(String text, String pattern) {
		String loc = "";
		StringBuilder sb = new StringBuilder();
		
		int idx = 0;
		
		int[] table = makeTable(pattern);
		
		for (int i = 0; i<text.length(); i++) {
			
			while (idx>0 && text.charAt(i)!=pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(text.charAt(i)==pattern.charAt(idx)) {
				if(idx==pattern.length()-1) {
					cnt++;
					sb.append(i-pattern.length()+2).append(" ");

					
					idx = table[idx];
				}
				else {
					idx++;
				}
			} 
		}
		return sb;
	}
	
	static int[] makeTable (String pa) {
		int[] t = new int[pa.length()];
		
		int idx = 0;
		
		for (int i = 1; i<pa.length(); i++) {
			
			while (idx>0 && pa.charAt(i)!= pa.charAt(idx)) {
				idx = t[idx-1];
			}
			
			if(pa.charAt(i)== pa.charAt(idx)) {
				idx++;
				t[i] = idx;
			}
		}
		
		
		return t;
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1786"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = br.readLine();
		p = br.readLine();
		
		
		
		
		StringBuilder sv =kmp(t,p);
		System.out.println(cnt);
		System.out.println(sv);
	}

}
