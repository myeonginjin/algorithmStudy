package a0703.prim;

import java.io.*;
import java.util.*;

public class PrimMain {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0703/prim/input_prim"));
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
			
			//아직 연결되지않은 정점 중 간선의 가중치가 가장 적은 곳 찾기
			for (int j = 0; j<N; j++) {
				if(!v[j] && min>minEdge[j]) {
							min=minEdge[j];
					        minVertex=j;
				}
			}
			v[minVertex]=true;
			sum+=min;
			System.out.println(Arrays.toString(v));
			System.out.println("minVertex="+minVertex);
			System.out.println("min="+min+" sum="+sum);
			if(cnt++==N-1) break;
			
			//영역이 넓어졌으니, 넓어진 영역(추가된 간선)을 통해 뻗어나갈 수 있는 간선 중에 기존 간선보다 개선된 간선이 있는지 탐색 후 기록
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


