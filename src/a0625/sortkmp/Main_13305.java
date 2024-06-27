package a0625.sortkmp;

import java.util.*;
import java.io.*;

public class Main_13305 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		int[] distance = new int[n-1];
		
		for (int i = 0; i<n-1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		
		str = br.readLine();
		st = new StringTokenizer(str);
		int[] price = new int[n];
		for(int i= 0; i<n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(distance));
//		System.out.println(Arrays.toString(price));
		
		int minPrice = 1000000000;
		long sum = 0;
		
		for (int i = 0; i<n-1; i++) {
			if(minPrice > price[i]) {
				minPrice = price[i];
			}
			sum += (long)minPrice*distance[i];
		}
		
		System.out.println(sum);
	}
}
