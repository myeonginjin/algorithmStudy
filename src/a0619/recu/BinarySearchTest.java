package a0619.recu;

import java.io.*;
import java.util.*;

public class BinarySearchTest {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_0000"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			//알고리즘
			
			int ans = -1;
			
			int N = Integer.parseInt(br.readLine());
			int[] a = new int[N];
			
			//15 27 39 77 92 1077 121
			
			st = new StringTokenizer(br.readLine()," ");
			
			for (int i = 0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			int key = Integer.parseInt(br.readLine()); //39
			ans = Arrays.binarySearch(a,key);
			
			//System.out.println(Arrays.toString(a));
			
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		
		
		System.out.print(sb.toString());
		
		br.close();
		
	}
}
