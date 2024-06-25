package a0625.sortkmp;

import java.util.Arrays;

public class MergeSort {
	static int[] a = {69,10,30,2,16,8,31,22};
	static int[] s;
	
	static void mergesort(int L , int R) {
		if(L<R) {
			int M = (L+R)/2;
			mergesort(L, M);
			mergesort(M+1, R);
			merge(L,M,R);
			System.out.println(Arrays.toString(a));
		}
	}
	
	static void merge(int L, int M, int R) {
		int i = L, j = M+1, k=L;
		while(i<=M && j<=R) {
			if(a[i]<=a[j]) s[k++] = a[i++];
			else 		   s[k++] = a[j++];  
		}
		if(i>M) {
			for (int l = j; l<=R; l++) s[k++]=a[l];
		} else {
			for (int l = i; l<=M; l++) s[k++]=a[l];
		}
		for(int l=L; l<=R; l++) a[l]=s[l];
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		s = new int[a.length];
		mergesort(0,a.length-1);
	}

}
