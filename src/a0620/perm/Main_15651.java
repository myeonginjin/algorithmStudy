package a0620.perm;

import java.util.*;
import java.io.*;

public class Main_15651 {
	public static int n,m;
	public static int[] nums = new int[7];
	public static boolean[] isPick = new boolean[8];
	public static StringBuilder sb = new StringBuilder();
	
	public static void perm(int index) {

		
		if (index == m) {

			for (int i = 0; i<m; i++) {
				sb.append(nums[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i<=n; i++) {
			//if(isPick[i]) continue;
			//isPick[i] = true;
			nums[index] = i;
			
			perm(index+1);
			
			//isPick[i] = false;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
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
