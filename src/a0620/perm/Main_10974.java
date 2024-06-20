package a0620.perm;

import java.util.*;
import java.io.*;

public class Main_10974 {
	public static int n;
	public static int[] nums = new int[8];
	public static boolean isPick[] = new boolean[9];
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void perm(int index) {
		if(index == n) {
			for (int i = 0; i<n; i++) {
				sb.append(nums[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i<=n; i++) {
			if (isPick[i]) continue;
			
			isPick[i] = true;
			nums[index] = i; 
			perm(index+1);
			
			isPick[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		perm(0);
		
		System.out.println(sb);
	
		
		
		
	}
}
