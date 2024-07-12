package study;

import java.util.*;
import java.io.*;


public class alice_5 {
	static int n;
	static int[] nums;
	static int[] pick;
	static boolean v[];
	static HashSet<Integer> hs;
	
    static boolean subsetSums(int[] arr, int index, boolean last) {
        int n = index;
        HashSet<Integer> subsetSums = new HashSet<>();
        
        // 총 2^n개의 부분집합 생성
        for (int i = 0; i < (1 << n); i++) {  // 1 << n 은 2^n을 의미
            int subsetSum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // i의 j번째 비트가 1인 경우
                    subsetSum += arr[j];
                }
            }
            subsetSums.add(subsetSum);
        }
        
        if(last) {
            for (int t : hs) {
            	if(!subsetSums.contains(t)) return false;
            }
        } else {
        	for(int t : subsetSums) {
        		if(!hs.contains(t)) return false;
        	}
        }

        return true;
    }
	
	static void comb(int index, int str) {
		if(!subsetSums(pick, index, false)) return;
		
		if(index == n) {

			if(subsetSums(pick, index, true)) {
				Arrays.sort(pick);
				for (int i = 0; i<n; i++) System.out.print(pick[i]+" ");
				System.exit(0);
			}
			
			return;
		}
		
		for (int i = str; i<nums.length; i++) {
			if(v[i]) continue;
			
			pick[index] = nums[i];
			v[i] = true;
			
			comb(index+1, i);
			
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		nums = new int[(int)Math.pow(2, n)];
		pick = new int[n];
		v = new boolean[(int)Math.pow(2, n)];
		hs = new HashSet<>();
		
		for (int i = 0; i<Math.pow(2, n); i++) {
			int t = Integer.parseInt(st.nextToken());
			nums[i] = t;
			hs.add(t); 
		}
		Arrays.sort(nums);
		
		if(n!= 1) {
			pick[0] = nums[1];
			pick[1] = nums[2];
		}
		
		if(n==1) {
			System.out.println(nums[1]);
			System.exit(0);
		}

		
		//System.out.println(Arrays.toString(nums));
		//System.out.println(Arrays.toString(pick));
		
		comb(2, 2);
		
		
	}
}
