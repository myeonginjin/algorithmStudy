package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10989 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int[] arr = new int[n];
		
		for (int i = 0; i<n; i++) {
			int t = Integer.parseInt(br.readLine());
			arr[i] = t;
		}
		Arrays.sort(arr);
		for (int i = 0; i<n; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
