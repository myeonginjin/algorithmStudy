package a0702.kruskal;

import java.util.*;
import java.io.*;

public class DisjointSetMain {
    static int N;
    static int[] p;

    static void make() {
        p = new int[N];
        for (int i = 0; i < N; i++) p[i] = i;
    }

    static int find(int a) {
        if(p[a] == a) return a;
//        int root = find(p[a]);
//        p[a] = root;
//        return p[a];
        return p[a]=find(p[a]);  //메모이 제이션 -> 하나하나 거쳐가는 것이 아니라 바로 결과 찾기 위해 저장!
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);        // a 부모 찾기
        int bRoot = find(b);        // b 부모 찾기
        if(aRoot == bRoot) return false;
        p[bRoot]=aRoot;				// 문제 잘 보고 누구를 부모로 할 것인지 잘 생각하고 코딩해야 한다.
        return true;
    }

    public static void main(String[] args) throws Exception{
    	N=5;
    	make();
    	System.out.println("{0, 1, 2, 3, 4}");
    	System.out.println(Arrays.toString(p));

    	System.out.println(union(0,1));
    	System.out.println("{0, 1, 2, 3, 4}");
    	System.out.println(Arrays.toString(p));
    	
    	System.out.println(union(2,1));
    	System.out.println("{0, 1, 2, 3, 4}");
    	System.out.println(Arrays.toString(p));

    	System.out.println(union(3,2));
    	System.out.println("{0, 1, 2, 3, 4}");
    	System.out.println(Arrays.toString(p));

    	System.out.println(union(4,3));
    	System.out.println("{0, 1, 2, 3, 4}");
    	System.out.println(Arrays.toString(p));
    	System.out.println("===find===");
    	System.out.println(find(4));
    	System.out.println("{0, 1, 2, 3, 4}");
    	System.out.println(Arrays.toString(p));
    	System.out.println(find(3));
    	System.out.println("{0, 1, 2, 3, 4}");
    	System.out.println(Arrays.toString(p));
    	System.out.println(find(2));
    	System.out.println("{0, 1, 2, 3, 4}");
    	System.out.println(Arrays.toString(p));
    }
}