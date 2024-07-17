package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10989_2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] count = new int[10001];  
		
		for (int i = 0; i<n; i++) {
			int t = Integer.parseInt(br.readLine());
			count[t]++;
		}

		for (int i = 1; i<10001; i++) {
			int cnt = count[i];
			
			if(cnt!=0) {
				for (int j = 0; j<cnt; j++) {
					sb.append(i).append("\n");
				}
			}
			
		}
		
		System.out.println(sb);
		
	}

}
