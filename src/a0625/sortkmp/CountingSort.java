package a0625.sortkmp;

import java.util.Arrays;

public class CountingSort {
	
	public static void main(String[] args) {
		int[] a = {0,4,1,3,1,2,4,1};
		int max = a[0];
		
		for (int i = 1; i<a.length; i++) {
			if(max<a[i]) {
				max=a[i];
			}
		}
		
		int m = Arrays.stream(a).max().getAsInt();
		System.out.println(m);
		System.out.println(max);
		System.out.println(Arrays.toString(a));
		
		int[] c = new int[m+1];
		int[] s = new int[a.length];
		System.out.println(Arrays.toString(a));
		
		for (int i = 0; i<a.length; i++) c[a[i]]++;
		System.out.println(Arrays.toString(c));
		
		for (int i = 1; i<c.length; i++) c[i] += c[i-1];
		System.out.println(Arrays.toString(c));
		
		for (int i = 1; i<a.length; i++) s[--c[a[i]]]=a[i];
		System.out.println(Arrays.toString(s));
		
		
	}

}
