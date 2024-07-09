package study;

import java.util.*;
import java.io.*;

public class Main_9934 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int[] nodes = new int[(int)Math.pow(2,n)-1];
		
		for (int i = 0; i<Math.pow(2,n)-1; i++) {
			nodes[i] = Integer.parseInt(st.nextToken());
		}
		int l = (int)Math.pow(2,n);
		sb.append(nodes[l/2]).append("\n");
		
		//for (int i = 0; )
		
	}
}
