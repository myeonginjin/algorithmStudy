package a1001.LIS;

import java.io.*;
import java.util.*;

public class Main_12738_가장긴증가하는부분수열3 {
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<>();
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		arr.add(Integer.parseInt(st.nextToken()));
		
		for (int i = 1; i<n; i++) {
			int t = Integer.parseInt(st.nextToken());
			
			if (arr.get(arr.size()-1) < t) {
				arr.add(t);
			} else if (arr.get(arr.size()-1) == t){
				continue;
			} else {
				int index = binarySearch(0, arr.size()-1, t);
				arr.set(index, t);
			}
		}
		
		System.out.println(arr.size());
		
	}
	
	static int binarySearch(int str, int las, int target) {
		if(str == las) return str;
		
		int midIndex = (str + las) / 2;
		
		if (arr.get(midIndex) < target) {
			return binarySearch(midIndex+1, las, target);
			
		} else if (arr.get(midIndex) == target) return midIndex;
		
		else {
			return binarySearch(str, midIndex, target);
		}
		
		
		
	}

}
