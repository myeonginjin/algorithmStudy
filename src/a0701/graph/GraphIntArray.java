package a0701.graph;

import java.io.*;
import java.util.*;

public class GraphIntArray {
	public static void main(String[] args) {
		//메모리 2048기준
		//int[] a = new int[1_065_877_500]; //OK
		//int[] a = new int[1_065_877_501]; //OutOfMemortError
		int[][] a = new int[32_541][32_541]; //OK
		//int[][] a = new int[32_542][32_542]; //OK
		
		System.out.println(a);
		
		int[] ia = new int[3];
		ia[0] = 'A';
		System.out.println(Arrays.toString(ia));
		System.out.println();
		
		List<Integer>[] la = new List[3];
		
		for (int i = 0; i<la.length; i++) la[i] = new ArrayList<>();
		la[0].add(123);
		
		System.out.println(Arrays.toString(la));
	}
}
