package study;

import java.util.*;
import java.io.*;

public class Main_9934 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] nodes;
	static List<Integer>[] arr;
	
	static void dfs(int str, int las, int degree) {
		if(degree > n) return;
		int mid = (str + las)/2;
		
		arr[degree].add(nodes[mid]);
		dfs(str, mid, degree+1);
		dfs(mid+1, las, degree+1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		nodes = new int[(int)Math.pow(2,n)];
		arr = new ArrayList[n+2]; for (int i = 0; i<=n+1; i++) arr[i] = new ArrayList<>();		 
		
		for (int i = 1; i<=Math.pow(2,n)-1; i++) {
			nodes[i] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(nodes));
		
		dfs(1, (int)Math.pow(2,n)-1 , 1);
		
		for (int i = 1; i<=n; i++) {
			for (int t:arr[i]) sb.append(t+" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
