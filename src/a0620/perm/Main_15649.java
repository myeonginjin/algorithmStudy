package a0620.perm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15649 {
	public static int n,m;
	public static StringBuilder sb = new StringBuilder();
	public static int[] pick = new int[8];
	public static boolean[] v =  new boolean[9];
	
	public static void perm(int index) {
		if(index == m) {
			for (int i = 0; i<m; i++) sb.append(pick[i]+" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i<=n; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			pick[index] = i;
			perm(index+1);
			
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		

		
		perm(0);
		
		System.out.println(sb);
		
		br.close();
		
	}

}
