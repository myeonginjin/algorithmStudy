package a0625.sortkmp;

import java.util.*;
import java.io.*;

public class Main_1931 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> arr = new ArrayList<>(); 
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			arr.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(arr, (o1,o2)-> {
			if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
			return Integer.compare(o1[1], o2[1]);
		});
		
		//for(int[] t : arr) System.out.println(t[0]+" "+t[1]);
		
		int cnt = 1;
		int preLastTime = arr.get(0)[1];
		
		for (int i = 1; i<n; i++) {
			if(arr.get(i)[0] >= preLastTime) {
				cnt++;
				preLastTime = arr.get(i)[1];
			}
		}
		
		System.out.println(cnt);
		
	}
}

