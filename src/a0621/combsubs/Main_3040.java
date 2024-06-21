package a0621.combsubs;

import java.util.*;
import java.io.*;

public class Main_3040 {
	static int[] a = new int[9];
	static int[] b = new int[7];
	static boolean[] v = new boolean[9];
	
	static void perm(int index, int str) {
		if(index == 7) {
			int sum = 0;
			for(int n : b) sum+=n;
			
			if (sum==100) {
				for(int n:b)System.out.println(n);
				System.exit(0);
			}
			
			return;
		}
		
		
		for (int i = str; i<9; i++) {
			if(v[i]) continue;
			
			b[index] = a[i];
			v[i] = true;
			perm(index+1,i+1);
			
			v[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<9; i++) {
			int num = Integer.parseInt(br.readLine());
			a[i] = num;
		}
		
		perm(0, 0);

	}

}
