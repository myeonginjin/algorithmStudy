package study;
import java.util.*;
import java.io.*;

public class Main_14225 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		for (int i = 0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken()); 
		}
		
		boolean[] v = new boolean[2000001];
		
		for (int i = 1; i< 1<<n; i++) {
			int sum = 0;
			
			for (int j = 0; j<n; j++) {
				if((i & 1<<j) != 0) sum += a[j];
			}
			if(sum < v.length) v[sum] = true; 
		}
		
		for (int i = 1; i<v.length; i++) {
			if(!v[i]) {
				System.out.println(i);
				break;
			}
			
		}
	}

}
