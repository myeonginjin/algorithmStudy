package a0701.graph;

import java.io.*;
import java.util.*;

public class Main_12015_가장긴증가하는부분수열2 {
	static int n;
	static ArrayList<Integer> arr;
	
	
	static int binarySearch(int str, int las , int num) {
		
		if (str == las) return str;
		
		int mid = (str + las) / 2;
		
		int midNum = arr.get( mid );
		
		if(num > midNum) {
			return binarySearch(mid+1, las, num);
		}  else if (num == midNum) {
			return (str + las) / 2;
		} else {
			return binarySearch(str, mid, num);
		}
		
	 
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		arr.add(Integer.parseInt(st.nextToken()));
		
		
		for (int i = 1; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(arr.get(arr.size()-1) < num) {
				arr.add(num);
			} else {
				int index = binarySearch(0, arr.size()-1, num);
				arr.set(index, num);
			}
			
			//System.out.println(arr);
			
		}
		
		System.out.println(arr.size());
		
		//System.out.println(arr);
		
		
		
		
	}

}
