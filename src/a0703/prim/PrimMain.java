package a0703.prim;

import java.io.*;
import java.util.*;

public class PrimMain {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/a0703/prim/input_prim"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<int[]>[] g = new List[N]; for (int i = 0; i<N; i++) g[i] = new ArrayList<>();
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				int c = sc.nextInt();
				if(c!=0) g[i].add(new int[] {j,c}); //인접정점번호, 비용
			}
		}
		
		boolean[] v = new boolean[N];
		int[] minEdge = new int[N];
		for(int i = 0; i<N; i++) minEdge[i] = Integer.MAX_VALUE;       //Arrays.fill(minEdge, Integer.MAX_VALUE); 값에 연산이 필요한 경우 멕스벨류를 넣는건 위험함 그래서 Integer.MAX_VALUE/2 혹은 987..이렇게 넣자
		
		int sum=0,cnt=0;
		minEdge[0]=0;
		//System.out.println(Arrays.toString(minEdge)); System.out.println();
		for(int i = 0; i<N; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j = 0; j<N; j++) {
				if(!v[j] && min>minEdge[j]) {
							min=minEdge[j];
					        minVertex=j;
				}
			}
			v[minVertex]=true;
			sum+=min;
//			System.out.println(Arrays.toString(v));
//			System.out.println("minVertex="+minVertex);
//			System.out.println("min="+min+" sum="+sum);
			if(cnt++==N-1) break;
			
			for (int[] j : g[minVertex]) {
				if(!v[j[0]] && minEdge[j[0]]>j[1]) {
							   minEdge[j[0]]=j[1]; //
				}
			}
			System.out.println(Arrays.toString(minEdge)); System.out.println();
		}
		System.out.println(sum);
		sc.close();
	}

}


