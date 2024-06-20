package a0620.perm;

import java.util.*;
import java.io.*;

public class Main_14888 {
	public static int n; 
	public static int[] nums = new int[11];
	public static int types[] = new int[4]; 
	public static List<Integer> calcul = new ArrayList<>(); 
	public static int maxAns = Integer.MIN_VALUE;
	public static int minAns = Integer.MAX_VALUE;
	
	public static void recursive(int cnt) {
		if(cnt == n-1) {
			getAns();
			return;
		}
		
		for (int i = 0; i<4; i++) {
			if(types[i]==0) continue;
			
			types[i] = types[i] -1;
			calcul.add(i);
			
			recursive(cnt+1);
			
			calcul.remove(calcul.size()-1);
			types[i] = types[i] + 1;
		}
	}
	
	public static void getAns() {
		if(calcul.size()!=n-1) {
			System.out.println("????!!!??");
			return;
		}
		
		int ans = nums[0];
		int index = 0;
		
		for (int i = 1; i<n; i++) {
			switch (calcul.get(index++)) {
			case 0:
				ans += nums[i];
				break;
			case 1:
				ans -= nums[i];
				break;
			case 2:
				ans *= nums[i];
				break;
			case 3:
				ans /= nums[i];
				break;
			}
		}
		
		maxAns = Math.max(maxAns,ans);
		minAns = Math.min(minAns, ans);
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/test14888"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		str = br.readLine();
		st = new StringTokenizer(str);
		
		for (int i = 0; i<n; i++) {
			nums[i]= Integer.parseInt(st.nextToken());
		}
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		for (int i = 0; i<4; i++) {
			types[i] = Integer.parseInt(st.nextToken());
		}
		
		recursive(0);
		
		System.out.println(maxAns);
		System.out.println(minAns);
		
		br.close();
		

		
		
	}

}
