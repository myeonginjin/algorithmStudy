package study;

import java.io.*;
import java.util.*;

public class Main_1991 {
	static int n;
	static StringBuilder sb = new StringBuilder();
	static char[] tree;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/study/input_1991"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String str;
		StringTokenizer st;
		tree = new char[n*2+2];
		tree[1] = 'A';

		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			
			left = left == '.' ? 'x' : left;
			
			tree[(root - 'A' + 1) * 2] = left;
			char right = st.nextToken().charAt(0);
			right = right == '.' ? 'x' : right;
			tree[(root - 'A' + 1) * 2 + 1] = right;
		}
		System.out.println((int)'F' +" "+ (int)'A');
		System.out.println(('F' - 'A' +1) *2);
		System.out.println(('F' - 'A' +1)*2+1);
		System.out.println(Arrays.toString(tree));
	}
}
