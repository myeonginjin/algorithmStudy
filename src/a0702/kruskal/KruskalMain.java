package a0702.kruskal;

import java.util.*;
import java.io.*;

public class KruskalMain {
	static int N;
	static int[][] g;
	static int[] p;
	
	  static void make() {
	        p = new int[N];
	        for (int i = 0; i < N; i++) p[i] = i;
	    }
	
	 static int find(int a) {
	        if(p[a] == a) return a;
	        return p[a]=find(p[a]);  //메모이 제이션 -> 하나하나 거쳐가는 것이 아니라 바로 결과 찾기 위해 저장!
	    } 

	    static boolean union(int a, int b) {
	        int aRoot = find(a);        // a 부모 찾기
	        int bRoot = find(b);        // b 부모 찾기
	        if(aRoot == bRoot) return false;
	        p[bRoot]=aRoot;				// 
	        return true;
	    }
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0702/kruskal/input_kruskal.txt"));
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		int E=sc.nextInt();
		g=new int[E][3];
		for(int i=0; i<E; i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			int cost=sc.nextInt();
			g[i]=new int[] {from, to, cost};
		}
//		for(int[] e:g) System.out.println(Arrays.toString(e)); System.out.println();
		Arrays.sort(g, (o1,o2)->Integer.compare(o1[2],  o2[2]));
		for(int[] e:g) System.out.println(Arrays.toString(e)); System.out.println();
		make();
		int sum=0,cnt=0;
		for(int[] e:g) {
			System.out.println(Arrays.toString(p));
			if(union(e[0],e[1])) {
				sum+=e[2];
				if(++cnt==N-1) break;
			}
		}
		sc.close();
	}
}