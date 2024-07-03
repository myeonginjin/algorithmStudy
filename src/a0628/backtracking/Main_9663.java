package a0628.backtracking;

import java.util.*;
import java.io.*;

public class Main_9663 {
	static int n;
	static int[] arr;
	static int cnt;
	
	static boolean canGo (int rI) {
		

		for (int i = 0; i<rI; i++) {
			
//			if(rI == 1 && cnt==0 && arr[0]==1) {
//				System.out.print(i+"        ");
//				System.out.println("arr[i] :"+arr[i] +"  arr[ri] : "+ arr[rI] +"        " + Math.abs(rI-i) +  " " +  Math.abs(arr[rI] - arr[i]) );
//				System.out.println();
//			}
			
			
			if(arr[i] == arr[rI] || Math.abs(rI-i) == Math.abs(arr[rI] - arr[i])) {
				return false;
			}
		}
		return true;
	}
	
	static void back (int rIndex) {
		if(!canGo(rIndex-1)) return;
		
		if(rIndex == n) {
			cnt++;
			
			//for(int i : arr) System.out.println(i);
			//System.out.println();
			
			return;
		}
		
		for (int i = 0; i<n; i++) {
			arr[rIndex] = i;
			back(rIndex+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		back(0);
		System.out.println(cnt);
	}

}
