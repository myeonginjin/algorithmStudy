package a0625.sortkmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;


//p.284
public class KMPMain {
	public static void main(String[] args) {
		          //012345678901 
		String T = "ABCDABCDABCDE";
		String P =        "ABCDABD";
		int[] F = new int[P.length()];
		
		System.out.println(Arrays.toString(F));
		
		//T = "ABABACA";
		//P = "ABABACA";
		
		for(int t = 1, p = 0; t < P.length(); t++) {
			while(p>0 && P.charAt(t)!=P.charAt(p)) p = F[p-1];
			if(P.charAt(t) == P.charAt(p)) F[t]= ++p;
		}
		
		
		List<Integer> ans = new ArrayList<>();
		for(int t = 0, p = 0; t < T.length(); t++) {
			while(p>0 && T.charAt(t)!=P.charAt(p)) p = F[p-1];
			if(T.charAt(t)==P.charAt(p)) {
				if(p==P.length()-1) {
					ans.add(t-p);
					p = F[p];
				} else {
					++p;
				}
			}
		}
		System.out.println(Arrays.toString(F));
		
		
		
		
		System.out.println(ans.size());
		System.out.println(ans);
		
	}
}
